package org.id.customerservice.mappers;

import org.id.customerservice.dto.RequestCustomer;
import org.id.customerservice.dto.ResponseCustomer;
import org.id.customerservice.entities.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer requestCustomerToCustomer(RequestCustomer requestCustomer);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ResponseCustomer customerToResponseCustomer(Customer customer);
}
