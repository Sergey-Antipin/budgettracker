package com.example.budgettracker.service;

import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.model.Operation;

import java.util.Date;
import java.util.List;

public interface OperationService {

    Operation create(OperationDto operation, int accountId);

    void update(OperationDto dto, int accountId);

    void delete(int id, int accountId);

    OperationDto get(int id, int accountId, boolean excess);

    List<OperationDto> getAll(List<Integer> accountsId);

    List<OperationDto> getByPeriod(List<Integer> accountsId, Date start, Date end);
}
