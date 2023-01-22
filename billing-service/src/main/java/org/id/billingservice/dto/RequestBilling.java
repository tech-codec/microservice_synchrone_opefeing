package org.id.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.id.billingservice.entities.ProductItem;


import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class RequestBilling {
    private Long cutomerId;
    private List<ProductItem> productItems;
}
