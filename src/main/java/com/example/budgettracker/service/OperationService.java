package com.example.budgettracker.service;

import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.model.Operation;

import java.time.LocalDate;
import java.util.List;

public interface OperationService {

    Operation create(OperationDto operation, int accountId);

    void update(OperationDto dto, int accountId);

    void delete(int id, int accountId);

    OperationDto get(int id, int accountId);

    List<OperationDto> getAll(List<Integer> accountsId);

    List<OperationDto> getByPeriod(List<Integer> accountsId, LocalDate start, LocalDate end);
}
