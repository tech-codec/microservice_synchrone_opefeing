package org.id.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private double amount;
    private Long customerId;
    @OneToMany(mappedBy = "billing", fetch = FetchType.LAZY)
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}
