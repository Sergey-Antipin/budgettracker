package com.example.budgettracker.repository;

import com.example.budgettracker.model.Account;
import com.example.budgettracker.model.User;
import com.example.budgettracker.util.exception.EntityAccessException;
import com.example.budgettracker.util.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Account save(Account account, int userId) {
        account.setUser(em.getReference(User.class, userId));
        if (account.isNew()) {
            em.persist(account);
            return account;
        }
        return em.merge(account);
    }

    @Override
    public void delete(int id, int userId) throws EntityAccessException {
        int rowsAffected = em
                .createQuery("DELETE FROM Account a WHERE a.id = :id AND a.user.id = :userId", Account.class)
                .setParameter("id", id)
                .setParameter("userId", userId)
                .executeUpdate();
        if (rowsAffected == 0 && em.getReference(Account.class, id) != null) {
            //case when user is not owner of this operation
            throw new EntityAccessException(id, userId);
        }
    }

    @Override
    public Account get(int id, int userId) throws EntityAccessException, NotFoundException {
        Account account = em.find(Account.class, id);
        if (account != null && account.getUser().getId() != userId) {
            throw new EntityAccessException(id, userId);
        } else if (account == null) {
            throw new NotFoundException(id);
        }
        return account;
    }

    @Override
    public List<Account> getAll(int userId) {
        return em.createQuery("SELECT a FROM Account a WHERE a.user.id = :userId", Account.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
