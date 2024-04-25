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

    List<Operation> getAll(int accountId);

    List<Operation> getByPeriod(int accountId, Date start, Date end);

    /*List<Operation> getByCategories(int accountId, OperationCategory... categories);

    List<Operation> getLessThan(int accountId, Money money);

    List<Operation> getGreaterThan(int accountId, Money money);*/
}
