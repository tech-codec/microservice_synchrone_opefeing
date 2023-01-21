package org.id.customerservice.mappers;

import org.id.customerservice.dto.RequestCustomer;
import org.id.customerservice.dto.ResponseCustomer;
import org.id.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer requestCustomerToCustomer(RequestCustomer requestCustomer);
    ResponseCustomer customerToResponseCustomer(Customer customer);
}
