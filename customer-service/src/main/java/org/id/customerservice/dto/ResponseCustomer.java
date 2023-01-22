package org.id.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ResponseCustomer {
    private Long id;
    private String nameCustomer;
    private String email;
}
