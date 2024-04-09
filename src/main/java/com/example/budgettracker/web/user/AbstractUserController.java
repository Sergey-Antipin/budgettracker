package com.example.budgettracker.web.user;

import com.example.budgettracker.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractUserController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    private UserService service;

}
