package org.id.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.id.billingservice.entities.Product;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ResponseProductItem {
    private Long id;
    private double price;
    private double quantity;
    private Product product;
}
