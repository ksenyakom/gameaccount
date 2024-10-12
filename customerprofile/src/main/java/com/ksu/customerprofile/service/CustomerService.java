package com.ksu.customerprofile.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ksu.customerprofile.model.Customer;
import com.ksu.customerprofile.repository.CustomerRepository;

@Service
public class CustomerService {


    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    public static final int ITERATIOIN_NUMBER = 1;

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findCustomer(String login, String password) {
        String hashedPassword = HashService.hash512(password, ITERATIOIN_NUMBER);
        return customerRepository.findOne(login, hashedPassword);
    }

    public Customer saveCustomer(Customer customer) {
        log.info("Saving customer <{}>", customer.getLogin());
        String hashedPassword = HashService.hash512(customer.getPassword(), ITERATIOIN_NUMBER);
        customer.setPassword(hashedPassword);

        return customerRepository.save(customer);
    }

    public Customer findById(long customerId) {
        log.info("Finding customer <{}>", customerId);

        return customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
