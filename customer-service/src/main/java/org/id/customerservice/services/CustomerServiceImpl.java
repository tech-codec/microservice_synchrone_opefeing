package org.id.customerservice.services;

import org.id.customerservice.dao.CustomerRepository;
import org.id.customerservice.dto.RequestCustomer;
import org.id.customerservice.dto.ResponseCustomer;
import org.id.customerservice.entities.Customer;
import org.id.customerservice.mappers.CustomerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerServiceI {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    @Override
    public List<ResponseCustomer> allCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        List<ResponseCustomer> responseCustomers = customerList.stream()
                .map(customer -> customerMapper.customerToResponseCustomer(customer))
                .collect(Collectors.toList());
        return responseCustomers;
    }

    @Override
    public ResponseCustomer showCustomer(Long custmerId) {
        Customer customer = customerRepository.findById(custmerId).orElse(null);
        return customerMapper.customerToResponseCustomer(customer);
    }

    @Override
    public ResponseCustomer createCustomer(RequestCustomer requestCustomer) {
        Customer customer = customerMapper.requestCustomerToCustomer(requestCustomer);
        Customer customerSave = customerRepository.save(customer);
        return customerMapper.customerToResponseCustomer(customerSave);
    }

    @Override
    public ResponseCustomer updateCustomer(RequestCustomer requestCustomer, Long customerId)
    {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        customer.setEmail(requestCustomer.getEmail());
        customer.setNameCustomer(requestCustomer.getNameCustomer());
        Customer customerUpdate = customerRepository.save(customer);
        return customerMapper.customerToResponseCustomer(customerUpdate);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        customerRepository.delete(customer);
    }
}
