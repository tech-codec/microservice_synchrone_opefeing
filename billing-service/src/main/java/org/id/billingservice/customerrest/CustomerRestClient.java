package org.id.billingservice.customerrest;

import org.id.billingservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/api/ShowCustomer/{customerId}")
    Customer getCustomer(@PathVariable Long customerId);

    @GetMapping("/api/AllProducts")
    List<Customer> getAllCustomer();
}
