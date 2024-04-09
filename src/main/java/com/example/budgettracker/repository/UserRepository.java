package com.example.budgettracker.repository;

import com.example.budgettracker.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    void delete(int id);

    User get(int id);

    List<User> getAll();
}
