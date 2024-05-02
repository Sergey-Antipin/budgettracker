package com.example.budgettracker.model;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metamodel.spi.ValueAccess;
import org.hibernate.usertype.CompositeUserType;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

public final class MoneyCompositeType implements CompositeUserType<Money> {

    public MoneyCompositeType() {
    }

    @Override
    public Object getPropertyValue(Money component, int property) throws HibernateException {
        return switch (property) {
            case 0 -> component.getAmount();
            case 1 -> component.getCurrencyUnit().getCode();
            default -> throw new HibernateException("Illegal property index: " + property);
        };
    }

    @Override
    public Money instantiate(ValueAccess values, SessionFactoryImplementor sessionFactory) {
        final BigDecimal amount = values.getValue(0, BigDecimal.class);
        final String currency = values.getValue(1, String.class);
        return Money.parse(currency + " " + amount);
    }

    @Override
    public Class<?> embeddable() {
        return MoneyEmbeddable.class;
    }

    @Override
    public Class<Money> returnedClass() {
        return Money.class;
    }

    @Override
    public boolean equals(Money x, Money y) {
        if (x == y) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        return x.equals(y);
    }

    @Override
    public int hashCode(Money x) {
        return x.hashCode();
    }

    @Override
    public Money deepCopy(Money value) {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Money value) {
        return value;
    }

    @Override
    public Money assemble(Serializable cached, Object owner) {
        return (Money) cached;
    }

    @Override
    public Money replace(Money detached, Money managed, Object owner) {
        return detached;
    }

    public static class MoneyEmbeddable {
        private BigDecimal amount;
        private String currency;
    }
}
