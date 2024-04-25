package com.example.budgettracker.repository;

import com.example.budgettracker.model.Account;
import com.example.budgettracker.model.Operation;
import com.example.budgettracker.model.OperationCategory;
import com.example.budgettracker.util.exception.EntityAccessException;
import com.example.budgettracker.util.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TemporalType;
import org.joda.money.Money;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class OperationRepositoryImpl implements OperationRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Operation save(Operation operation, int accountId) {
        operation.setAccount(em.getReference(Account.class, accountId));
        if (operation.isNew()) {
            em.persist(operation);
            return operation;
        }
        return em.merge(operation);
    }

    @Override
    public void delete(int id, int accountId) throws EntityAccessException {
        int rowsAffected = em.createQuery("DELETE FROM Operation o WHERE o.id = :id AND o.account.id = :accountId")
                .setParameter("id", id)
                .setParameter("accountId", accountId)
                .executeUpdate();
        if (rowsAffected == 0 && em.getReference(Operation.class, id) != null) {
            throw new EntityAccessException(id, accountId);
        }
    }

    @Override
    public Operation get(int id, int accountId) throws EntityAccessException, NotFoundException {
        Operation operation = em.find(Operation.class, id);
        if (operation != null && operation.getAccount().getId() != accountId) {
            throw new EntityAccessException(id, accountId);
        } else if (operation == null) {
            throw new NotFoundException(id);
        }
        return operation;
    }

    @Override
    public List<Operation> getAll(int accountId) {
        return em.createQuery("SELECT o FROM Operation o WHERE o.account.id = :accountId " +
                        "ORDER BY date DESC", Operation.class)
                .setParameter("accountId", accountId)
                .getResultList();
    }

    @Override
    public List<Operation> getByPeriod(int accountId, Date start, Date end) {
        return em.createQuery("SELECT o FROM Operation o WHERE o.account.id = :accountId AND " +
                        "o.date >= :start AND o.date <= :end ORDER BY date DESC", Operation.class)
                .setParameter("accountId", accountId)
                .setParameter("start", start, TemporalType.DATE)
                .setParameter("end", end, TemporalType.DATE)
                .getResultList();
    }

    /*@Override
    public List<Operation> getByCategories(int accountId, OperationCategory... categories) {
        return em.createQuery("SELECT o FROM Operation o WHERE o.account.id = :accountId AND " +
                " ")
    }

    @Override
    public List<Operation> getLessThan(int accountId, Money money) {
        return List.of();
    }

    @Override
    public List<Operation> getGreaterThan(int accountId, Money money) {
        return List.of();
    }*/
}