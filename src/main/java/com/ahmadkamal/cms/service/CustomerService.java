package com.ahmadkamal.cms.service;

import com.ahmadkamal.cms.dao.CustomerDao;
import com.ahmadkamal.cms.exception.CustomerNotFoundException;
import com.ahmadkamal.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer){
        return customerDao.save(customer);
    }

    public List<Customer> getCustomers (){
        return customerDao.findAll();
    }

    public Customer getCustomerById (int custId){

        Optional<Customer> optionalCustomer = customerDao.findById(custId);
        if(!optionalCustomer.isPresent()){
            throw new CustomerNotFoundException("No such customer found...");
        }
        return optionalCustomer.get();
    }

    public Customer UpdateCustomer (int custId, Customer customer){
        customer.setCustomerId(custId);
        return customerDao.save(customer);
    }

    public void deleteCustomer(int custId){
        customerDao.deleteById(custId);
    }
}
