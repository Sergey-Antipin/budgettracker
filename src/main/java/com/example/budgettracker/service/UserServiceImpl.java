package com.example.budgettracker.service;

import com.example.budgettracker.model.User;
import com.example.budgettracker.repository.UserRepository;
import com.example.budgettracker.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        Assert.notNull(user, "passed user is null");
        return repository.save(user);
    }

    @Override
    public void update(User user) {
        Assert.notNull(user, "passed user is null");
        repository.save(user);
    }

    @Override
    public void delete(int id) {
        try {
            repository.delete(id);
        } catch (NotFoundException e) {
            //TODO
        }
    }

    @Override
    public User get(int id) {
        User user = null;
        try {
            user = repository.get(id);
        } catch (NotFoundException e) {
            //TODO
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.getByEmail(username);
    }
}
