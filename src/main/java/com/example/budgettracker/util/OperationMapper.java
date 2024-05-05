package com.example.budgettracker.util;

import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.model.*;
import org.springframework.stereotype.Component;

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

    private interface OperationFactory {

        Operation createOperation(OperationDto dto);
    }

    private static class OperationFactoryImpl implements OperationFactory {

        @Override
        public Operation createOperation(OperationDto dto) {
            String opType = dto.getCategory().getOperationType();
            if (opType.equals(ExpenseCategory.OPERATION_TYPE)) {
                return createExpenseOperation(dto);
            } else if (opType.equals(IncomeCategory.OPERATION_TYPE)) {
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
