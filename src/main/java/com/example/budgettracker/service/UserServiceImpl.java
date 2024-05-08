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
        User userToUpdate = repository.get(user.getId());
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
    public UserDto get(int id) {
        return mapper.toDto(repository.get(id));
    }

    @Override
    public UserDto getByEmail(String email) {
        return mapper.toDto(repository.getByEmail(email));
    }

    @Override
    public List<UserDto> getAll() {
        return mapper.getDtoList(repository.getAll());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.getByEmail(username);
    }
}
