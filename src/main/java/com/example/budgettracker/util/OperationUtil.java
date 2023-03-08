package com.example.budgettracker.util;

import com.example.budgettracker.model.dto.OperationDTO;
import com.example.budgettracker.model.Operation;
import com.example.budgettracker.model.OperationCategory;
import org.joda.money.Money;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperationUtil {

    public static OperationDTO createDTO(Operation operation, boolean excess) {
        return new OperationDTO(operation.getAmount(),
                operation.getDate(),
                operation.getDescription(),
                operation.getOperationCategory(),
                excess);
    }

    public static List<OperationDTO> getDTOList(List<Operation> operations, Map<OperationCategory, Money> limits) {
        Map<OperationCategory, Money> opSumByCategory = operations.stream()
                .collect(Collectors.toMap(Operation::getOperationCategory, Operation::getAmount, Money::plus));
        return operations.stream()
                .map(op -> {
                    OperationCategory category = op.getOperationCategory();
                    Money lim = limits.get(category);
                    boolean excess = false;
                    if (lim != null) {
                        excess = opSumByCategory.get(category).isLessThan(lim);
                    }
                    return createDTO(op, excess);
                }).collect(Collectors.toList());
        /*return operations.stream()
                .map(op -> createDTO(op, limits.get(op.getOperationCategory()) != null &&
                        opSumByCategory.get(op.getOperationCategory()).isLessThan(limits.get(op.getOperationCategory()))))
                .collect(Collectors.toList());*/
    }
}
