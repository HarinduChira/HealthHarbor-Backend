package com.healthharbor.HealthHarbor.Service;

import com.healthharbor.HealthHarbor.Collection.Customer;
import com.healthharbor.HealthHarbor.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> allCustomers(){
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer)
    {
        return customerRepository.save(customer);
    }

    public Optional<Customer> singleCustomer(String cusId){
        return customerRepository.findCustomerByCusId(cusId);
    }


}
