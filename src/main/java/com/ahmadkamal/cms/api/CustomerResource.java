package com.ahmadkamal.cms.api;

import com.ahmadkamal.cms.model.Customer;
import com.ahmadkamal.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerResource {

    @Autowired
    public CustomerService customerService;

    @PostMapping
    public Customer addCustomer (@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers (){
        return customerService.getCustomers();
    }

    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int custId){
        return customerService.getCustomerById(custId);
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int custId, @RequestBody Customer customer){
        return customerService.UpdateCustomer(custId, customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int custId){
        customerService.deleteCustomer(custId);
    }
}
