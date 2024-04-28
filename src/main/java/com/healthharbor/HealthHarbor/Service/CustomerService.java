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

    public Optional<Customer> getCustomerByEmail(String email) {

        return customerRepository.findCustomerByEmail(email);
    }

    public void updateCustomerDetails(String prevEmail, String name, String email, String contactNo, String addressNo, String addressStreet, String addressCity) {

        Optional<Customer> prevCusOptional = customerRepository.findCustomerByEmail(prevEmail);
        if (prevCusOptional.isPresent()) {
            Customer prevCus = prevCusOptional.get();
            if (name != null) {
                prevCus.setName(name);
            }
            if (email != null) {
                prevCus.setEmail(email);
            }
            if (contactNo != null) {
                prevCus.setContactNo(contactNo);
            }
            if (addressNo != null) {
                prevCus.setAddressNo(addressNo);
            }
            if (addressStreet != null) {
                prevCus.setAddressStreet(addressStreet);
            }
            if (addressCity != null) {
                prevCus.setAddressCity(addressCity);
            }
            customerRepository.save(prevCus);
        }
    }

    public void updatePassword(String prevEmail, String password) {

        Optional<Customer> prevCusOptional = customerRepository.findCustomerByEmail(prevEmail);

        if (prevCusOptional.isPresent()) {
            Customer prevCus = prevCusOptional.get();

            prevCus.setPassword(passwordEncoder.encode(password));

            customerRepository.save(prevCus);
        }
    }
}
