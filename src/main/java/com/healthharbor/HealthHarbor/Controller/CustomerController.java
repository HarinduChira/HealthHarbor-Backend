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
@RequestMapping("/api/Customer")
@CrossOrigin("http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/GetCus")
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        return new ResponseEntity<List<Customer>>(customerService.allCustomers(), HttpStatus.OK);
    }

    @PostMapping("/AddCus")
    public ResponseEntity<Customer> addCustomerToDb(@RequestBody Customer customer)
    {
        Customer newCustomer = customerService.addCustomer(customer);

        return new ResponseEntity<>(newCustomer,HttpStatus.CREATED);
    }

    @GetMapping("/Check/{email},{password}")
    public ResponseEntity<Optional<String>> getCusByEmailPass(@PathVariable String email,@PathVariable String password)
    {
        return new ResponseEntity<Optional<String>>(customerService.checkCusLogin(email,password),HttpStatus.OK);
    }



}
