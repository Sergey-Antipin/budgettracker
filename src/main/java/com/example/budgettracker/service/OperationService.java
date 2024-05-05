package com.example.budgettracker.service;

import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.model.Operation;

import java.util.Date;
import java.util.List;

public interface OperationService {

    Operation create(OperationDto operation, int accountId);

    void update(OperationDto dto, int accountId);

    void delete(int id, int accountId);

    Operation get(int id, int accountId);

    OperationDto getDto(int id, int accountId, boolean excess);

    List<Operation> getAll(int accountId);

    List<Operation> getByPeriod(int accountId, Date start, Date end);
}
