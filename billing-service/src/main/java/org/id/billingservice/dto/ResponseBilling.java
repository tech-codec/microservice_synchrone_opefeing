package org.id.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.id.billingservice.entities.Customer;
import org.id.billingservice.entities.ProductItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ResponseBilling {
    private Long id;
    private Date date;
    private double amount;
    private List<ProductItem> productItems;
    private Customer customer;

}
