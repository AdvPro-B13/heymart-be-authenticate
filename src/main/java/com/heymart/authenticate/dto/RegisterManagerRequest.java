package com.heymart.authenticate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterManagerRequest extends RegisterCustomerRequest {
    private String supermarketId;

    public RegisterManagerRequest(String firstName, String lastName, String username, String password,
            String supermarketId) {
        super(firstName, lastName, username, password);
        this.supermarketId = supermarketId;
    }
}
