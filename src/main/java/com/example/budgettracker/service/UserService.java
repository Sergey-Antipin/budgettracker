package com.example.budgettracker.service;

import com.example.budgettracker.model.User;

import java.util.List;

public interface UserService {
    User create(User user);

    void update(User user);

    void delete(int id);

    User get(int id);

    List<User> getAll();
}
