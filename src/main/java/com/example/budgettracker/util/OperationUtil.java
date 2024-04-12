package com.example.budgettracker.util;

import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.model.ExpenseCategory;
import com.example.budgettracker.model.Operation;
import com.example.budgettracker.model.OperationCategory;
import org.joda.money.Money;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperationUtil {

    public static OperationDto createDto(Operation operation, boolean excess) {
        return new OperationDto(operation.getId(),
                operation.getMoney(),
                operation.getDate(),
                operation.getDescription(),
                operation.getCategory(),
                excess);
    }

    public static List<OperationDto> getDtoList(List<Operation> operations, Map<ExpenseCategory, Money> limits) {
        Map<OperationCategory, Money> opSumByCategory = operations.stream()
                .collect(Collectors.toMap(Operation::getCategory, Operation::getMoney, Money::plus));
        return operations.stream()
                .map(op -> {
                    OperationCategory category = op.getCategory();
                    Money lim = limits.get(category);
                    boolean excess = false;
                    if (lim != null) {
                        excess = opSumByCategory.get(category).isLessThan(lim);
                    }
                    return createDto(op, excess);
                }).collect(Collectors.toList());
        /*return operations.stream()
                .map(op -> createDTO(op, limits.get(op.getCategory()) != null &&
                        opSumByCategory.get(op.getCategory()).isLessThan(limits.get(op.getCategory()))))
                .collect(Collectors.toList());*/
    }
}
