package com.example.budgettracker.service;

import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.User;

import java.util.List;

public interface UserService {

    User create(UserDto user);

    void update(UserDto user);

    void delete(int id);

    User get(int id);

    UserDto getDto(int id);

    List<User> getAll();
}
