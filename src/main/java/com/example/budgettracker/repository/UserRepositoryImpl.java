package com.example.budgettracker.repository;

import com.example.budgettracker.model.User;
import com.example.budgettracker.util.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        }
        return em.merge(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        int rowsAffected = em
                .createQuery("DELETE FROM User u WHERE u.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        if (rowsAffected == 0) {
            throw new NotFoundException(id);
        }
    }

    @Override
    public User get(int id) {
        User u = em.find(User.class, id);
        if (u == null) {
            throw new NotFoundException(id);
        }
        return u;
    }

    @Override
    public List<User> getAll() {
        return em.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    public User getByEmail(String email) {
        return (User) em.createQuery("SELECT u FROM User u WHERE u.email = :email")
                .setParameter("email", email)
                .getSingleResult();
    }
}
