package org.id.customerservice.services;


import org.id.customerservice.dto.RequestCustomer;
import org.id.customerservice.dto.ResponseCustomer;

import java.util.List;

public interface CustomerServiceI {
    List<ResponseCustomer> allCustomer();
    ResponseCustomer showCustomer(Long custmerId);
    ResponseCustomer createCustomer(RequestCustomer requestCustomer);
    ResponseCustomer  updateCustomer(RequestCustomer requestCustomer, Long customerId);
    void deleteCustomer(Long customerId);
}
