package org.id.billingservice.customerrest;

import org.id.billingservice.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductRestClient {

    @GetMapping("/api/ShowProduct/{productId}")
    Product getProduct(@PathVariable Long productId);

    @GetMapping("/api/AllProducts")
    List<Product> getAllProduct();
}
