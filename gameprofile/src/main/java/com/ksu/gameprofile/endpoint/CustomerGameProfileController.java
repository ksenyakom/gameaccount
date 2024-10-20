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
}
