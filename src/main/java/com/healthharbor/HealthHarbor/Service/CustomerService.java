package com.healthharbor.HealthHarbor.Service;

import com.healthharbor.HealthHarbor.Collection.Customer;
import com.healthharbor.HealthHarbor.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Customer> allCustomers()
    {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer)
    {
        Customer newCus = customer;

        newCus.setPassword(passwordEncoder.encode(newCus.getPassword()));

        return customerRepository.save(newCus);
    }

    public Optional<String> checkCusLogin(String email, String password) {

        Optional<Customer> OpUser = customerRepository.findCustomerByEmail(email);

        if (OpUser.isPresent())
        {
            Customer customer = OpUser.get();

            if (passwordEncoder.matches(password , customer.getPassword())){
                return Optional.of("Login Success");
            }else {
                return Optional.of("Invalid Password");
            }
        }else
        {
            return Optional.of("Customer Not Found");
        }
    }
}
