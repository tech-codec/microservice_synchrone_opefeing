package org.id.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Customer {
    private Long id;
    private String nameCustomer;
    private String email;
}
