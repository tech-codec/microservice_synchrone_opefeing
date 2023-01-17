package org.id.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ResponsProduct {
    Long id;
    String name;
    double price;
    String description;
}
