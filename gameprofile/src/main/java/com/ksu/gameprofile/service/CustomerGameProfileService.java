package com.ksu.gameprofile.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import com.ksu.gameprofile.model.CustomerAchievement;
import com.ksu.gameprofile.model.CustomerGameProfile;
import com.ksu.gameprofile.repository.CustomerGameProfileRepository;
import com.ksu.gameprofile.service.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CustomerGameProfileService {

    @Autowired
    private CustomerGameProfileRepository customerGameProfileRepository;

    public CustomerGameProfile find(long customerId) {
        return customerGameProfileRepository.findByCustomerId(customerId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public void process(CustomerAchievement customerAchievement) {
        log.info("Process customer achievement"+ customerAchievement);
        //todo logic
    }
}
