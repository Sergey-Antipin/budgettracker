package com.example.budgettracker.util;

import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.model.Operation;
import org.springframework.stereotype.Component;

@Component
public class OperationMapper {

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
        return switch (dto.getOperationCategory()) {

        }
    }

    public Operation updateFromDto(OperationDto dto) {

    }
}
