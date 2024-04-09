package com.example.budgettracker.model;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metamodel.spi.ValueAccess;
import org.hibernate.usertype.CompositeUserType;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public final class MoneyCompositeType implements CompositeUserType<Money> {

    public MoneyCompositeType() {
    }

    @Override
    public Object getPropertyValue(Money component, int property) throws HibernateException {
        return switch (property) {
            case 0 -> component.getAmount();
            case 1 -> component.getCurrencyUnit();
            default -> throw new HibernateException("Illegal property index: " + property);
        };
    }

    @Override
    public Money instantiate(ValueAccess values, SessionFactoryImplementor sessionFactory) {
        final BigDecimal amount = values.getValue(0, BigDecimal.class);
        final CurrencyUnit currency = values.getValue(1, CurrencyUnit.class);
        return Objects.requireNonNull(Money.of(currency, amount), "Currency and amount must not be null");
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
        return Objects.equals(x, y);
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
        private CurrencyUnit currency;
    }
}
