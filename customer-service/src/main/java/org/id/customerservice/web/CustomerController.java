package org.id.customerservice.web;


import org.id.customerservice.dto.RequestCustomer;
import org.id.customerservice.dto.ResponseCustomer;
import org.id.customerservice.services.CustomerServiceI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {
    private CustomerServiceI customerServiceI;

    public CustomerController(CustomerServiceI customerServiceI) {
        this.customerServiceI = customerServiceI;
    }

    @GetMapping("/AllCustomers")
    List<ResponseCustomer> allCustomer(){
        return customerServiceI.allCustomer();
    }

    @GetMapping("/ShowCustomer/{customerId}")
    ResponseCustomer showCustomer(@PathVariable Long customerId){
        return customerServiceI.showCustomer(customerId);
    }

    @PostMapping("/CreateCustomer")
    ResponseCustomer createCustomer(@RequestBody RequestCustomer requestCustomer){
        return customerServiceI.createCustomer(requestCustomer);
    }

    @PostMapping("/UpdateCustomer/{customerId}")
    ResponseCustomer updateCustomer(@RequestBody RequestCustomer requestCustomer, @PathVariable Long customerId){
        return customerServiceI.updateCustomer(requestCustomer, customerId);
    }

    @GetMapping("/DeleteCustomer/{customerId}")
    void deleteCustomer(@PathVariable Long customerId){
        customerServiceI.deleteCustomer(customerId);
    }
}
