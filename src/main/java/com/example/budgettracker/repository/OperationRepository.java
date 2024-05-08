package com.example.budgettracker.repository;

import com.example.budgettracker.model.Operation;
import com.example.budgettracker.model.OperationCategory;
import org.joda.money.Money;

import java.util.Date;
import java.util.List;

public interface OperationRepository {

    Operation save(Operation operation, int accountId);

    void delete(int id, int accountId);

    Operation get(int id, int accountId);

    List<Operation> getAll(List<Integer> accountsId);

    List<Operation> getByPeriod(List<Integer> accountsId, Date start, Date end);
}
