package com.example.budgettracker.service;

import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.User;
import com.example.budgettracker.repository.UserRepository;
import com.example.budgettracker.util.UserMapper;
import com.example.budgettracker.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository repository;

    private UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public User create(UserDto user) {
        Assert.notNull(user, "passed used is null");
        User newUser = mapper.createFromDto(user);
        return repository.save(newUser);
    }

    @Override
    @Transactional
    public void update(UserDto user) {
        Assert.notNull(user, "passed used is null");
        User userToUpdate = get(user.getId());
        repository.save(mapper.updateFromDto(user, userToUpdate));
    }

    @Override
    @Transactional
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
    public UserDto getDto(int id) {
        return mapper.toDto(get(id));
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
