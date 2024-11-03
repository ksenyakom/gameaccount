package com.ksu.gameprofile.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ksu.gameprofile.model.CustomerGameProfile;


@Repository
public interface CustomerGameProfileRepository extends CrudRepository<CustomerGameProfile, Long> {
    Optional<CustomerGameProfile> findByCustomerId(long customerId);

}
