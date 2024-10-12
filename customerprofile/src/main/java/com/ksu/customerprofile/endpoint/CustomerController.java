package com.ksu.customerprofile.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ksu.customerprofile.model.Customer;
import com.ksu.customerprofile.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping()
    public Customer getById(@RequestParam long customerId) {
        return customerService.findById(customerId);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer login(@RequestBody Customer customer) {
        return customerService.findCustomer(customer.getLogin(), customer.getPassword());
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
