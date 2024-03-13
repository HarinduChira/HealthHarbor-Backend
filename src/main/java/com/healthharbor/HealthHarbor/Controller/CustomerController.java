package com.healthharbor.HealthHarbor.Controller;

import com.healthharbor.HealthHarbor.Collection.Customer;
import com.healthharbor.HealthHarbor.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        return new ResponseEntity<List<Customer>>(customerService.allCustomers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomerToDb(@RequestBody Customer customer)
    {
        Customer newCustomer = customerService.addCustomer(customer);

        return new ResponseEntity<>(newCustomer,HttpStatus.CREATED);
    }

    @GetMapping("/{cusId}")
    public ResponseEntity<Optional<Customer>> getCusById(@PathVariable String cusId){
        return new ResponseEntity<Optional<Customer>>(customerService.singleCustomer(cusId),HttpStatus.OK);
    }
}
