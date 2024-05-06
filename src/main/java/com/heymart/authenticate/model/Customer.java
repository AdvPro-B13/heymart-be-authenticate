package com.heymart.authenticate.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter
@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends User {
    @JsonManagedReference
    @ElementCollection
    private List<String> couponIds;
    protected Customer() { super(); }
    @Builder
    public Customer(Long id, String firstName, String lastName,
                       String password, String username, String role,
                       boolean active, List<String> couponIds) {
        super(id,firstName,lastName,password,username,role,active);
        this.couponIds = couponIds;
    }

}
