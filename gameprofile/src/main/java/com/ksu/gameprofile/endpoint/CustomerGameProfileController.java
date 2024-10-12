package com.ksu.gameprofile.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ksu.gameprofile.model.CustomerGameProfile;
import com.ksu.gameprofile.service.CustomerGameProfileService;

@RestController
@RequestMapping("/customer/gameprofile")
public class CustomerGameProfileController {

    @Autowired
    private CustomerGameProfileService customerGameProfileService;

    @GetMapping(path = "/{id}")
    public CustomerGameProfile getProfile(@PathVariable("id") long gameProfileId) {
        return customerGameProfileService.find(gameProfileId);
    }


//
//    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Customer login(@RequestBody Customer customer) {
//        return customerService.findCustomer(customer.getLogin(), customer.getPassword());
//    }
//
//    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity register(@RequestBody Customer customer) {
//        customerService.saveCustomer(customer);
//        return new ResponseEntity(HttpStatus.CREATED);
//    }
}
