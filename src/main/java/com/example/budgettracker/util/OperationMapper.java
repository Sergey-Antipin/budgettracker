package com.example.budgettracker.util;

import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.model.*;
import org.joda.money.Money;
import org.springframework.stereotype.Component;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OperationMapper {

    private static final OperationFactory factory = new OperationFactoryImpl();

    public OperationMapper() {
    }

    public OperationDto toDto(Operation operation, boolean excess) {
        return new OperationDto(operation.getId(),
                operation.getMoney(),
                operation.getDate(),
                operation.getDescription(),
                operation.getCategory(),
                excess,
                operation.getAccount());
    }

    public Operation createFromDto(OperationDto dto) {
        return factory.createOperation(dto);
    }

    public Operation updateFromDto(Operation operation, OperationDto dto) {
        operation.setMoney(dto.getMoney());
        operation.setDate(dto.getDate());
        operation.setDescription(dto.getDescription());
        operation.setCategory(dto.getCategory());
        return operation;
    }

    public List<OperationDto> getDtoList(List<Operation> operations, Map<ExpenseCategory, Money> limits) {
        Map<OperationCategory, Money> opSumByCategory = operations.stream()
                .collect(Collectors.toMap(Operation::getCategory, Operation::getMoney, Money::plus));
        return operations.stream()
                .map(op -> {
                    boolean excess = false;
                    OperationCategory opCat = op.getCategory();
                    if (opCat.getOperationType().equals(OperationCategory.EXPENSE)) {
                        @SuppressWarnings("SuspiciousMethodCalls")
                        Money lim = limits.get(opCat);
                        if (lim != null) {
                            excess = opSumByCategory.get(opCat).isLessThan(lim);
                        }
                    }
                    return toDto(op, excess);
                }).toList();
        /*return operations.stream()
                .map(op -> createDTO(op, limits.get(op.getCategory()) != null &&
                        opSumByCategory.get(op.getCategory()).isLessThan(limits.get(op.getCategory()))))
                .collect(Collectors.toList());*/
    }

    private interface OperationFactory {

        Operation createOperation(OperationDto dto);
    }

    private static class OperationFactoryImpl implements OperationFactory {

        @Override
        public Operation createOperation(OperationDto dto) {
            String opType = dto.getCategory().getOperationType();
            if (opType.equals(OperationCategory.EXPENSE)) {
                return createExpenseOperation(dto);
            } else if (opType.equals(OperationCategory.INCOME)) {
                return createIncomeOperation(dto);
            } else {
                throw new RuntimeException("Illegal operation type: " + opType);
            }
        }

        private ExpenseOperation createExpenseOperation(OperationDto dto) {
            return new ExpenseOperation(dto.getId(),
                    dto.getMoney(),
                    dto.getDate(),
                    dto.getDescription(),
                    (ExpenseCategory) dto.getCategory());
        }

        private IncomeOperation createIncomeOperation(OperationDto dto) {
            return new IncomeOperation(dto.getId(),
                    dto.getMoney(),
                    dto.getDate(),
                    dto.getDescription(),
                    (IncomeCategory) dto.getCategory());
        }
    }
}
