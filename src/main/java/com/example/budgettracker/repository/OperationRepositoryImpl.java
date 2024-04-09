package com.example.budgettracker.repository;

import com.example.budgettracker.model.Account;
import com.example.budgettracker.model.Operation;
import com.example.budgettracker.util.exception.EntityAccessException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TemporalType;
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
        } else if (get(operation.getId(), accountId) == null) {
            return null;
        }
        return em.merge(operation);
    }

    @Override
    public boolean delete(Operation operation, int accountId) {
        return em.createQuery("DELETE FROM Operation o WHERE o.id = :id AND o.account.id = :accountId")
                .setParameter("id", operation.getId())
                .setParameter("accountId", accountId)
                .executeUpdate() != 0;
    }

    @Override
    public Operation get(int id, int accountId) {
        Operation operation = em.find(Operation.class, id);
        if (operation == null) {
            return null;
        } else if (operation.getAccount().getId() != accountId) {
            throw new EntityAccessException(id, accountId);
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
}