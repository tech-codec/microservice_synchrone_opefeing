package org.id.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class RequestProductItem {
    private Long productId;
    private double price;
    private double quantity;
}
