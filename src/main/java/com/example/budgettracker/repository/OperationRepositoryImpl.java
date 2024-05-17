package com.example.budgettracker.repository;

import com.example.budgettracker.model.Account;
import com.example.budgettracker.model.Operation;
import com.example.budgettracker.util.exception.EntityAccessException;
import com.example.budgettracker.util.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
    public List<Operation> getAll(List<Integer> accountsId) {
        return em.createQuery("SELECT o FROM Operation o WHERE o.account.id IN (:accountsId) " +
                        "ORDER BY date DESC", Operation.class)
                .setParameter("accountsId", accountsId)
                .getResultList();
    }

    @Override
    public List<Operation> getByPeriod(List<Integer> accountsId, LocalDate start, LocalDate end) {
        return em.createQuery("SELECT o FROM Operation o WHERE o.account.id IN (:accountsId) AND " +
                        "o.date >= :start AND o.date <= :end ORDER BY date DESC", Operation.class)
                .setParameter("accountsId", accountsId)
                .setParameter("start", start)
                .setParameter("end", end)
                .getResultList();
    }
}