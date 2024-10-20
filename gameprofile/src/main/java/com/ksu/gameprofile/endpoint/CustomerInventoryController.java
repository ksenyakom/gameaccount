package com.ksu.gameprofile.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ksu.gameprofile.model.CustomerInventory;
import com.ksu.gameprofile.service.CustomerInventoryService;

@RestController
@RequestMapping("/customer/inventory")
public class CustomerInventoryController {

    @Autowired
    private CustomerInventoryService customerInventoryService;

    @GetMapping(path = "/{customerId}")
    public List<CustomerInventory> getInventory(@PathVariable("customerId") long customerId) {
        return customerInventoryService.find(customerId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerInventory save(@RequestBody CustomerInventory customerInventory) {
        return customerInventoryService.save(customerInventory);
    }

}
