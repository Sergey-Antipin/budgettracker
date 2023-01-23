package com.example.budgettracker.model.dto;

import java.util.List;

public class UserDTO {

    private List<AccountDTO> accounts;

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    public UserDTO() {
    }

    public UserDTO(List<AccountDTO> accounts) {
        this.accounts = accounts;
    }
}
