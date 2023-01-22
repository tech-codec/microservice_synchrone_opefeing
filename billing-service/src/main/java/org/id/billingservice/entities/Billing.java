package org.id.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Billing {
    private Long id;
    private Date date;
    private double amount;
    private Long customerId;
    @OneToMany(mappedBy = "billing", fetch = FetchType.LAZY)
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}
