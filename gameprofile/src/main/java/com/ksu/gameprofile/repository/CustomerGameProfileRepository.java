package com.ksu.gameprofile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ksu.gameprofile.model.CustomerGameProfile;


@Repository
public interface CustomerGameProfileRepository extends CrudRepository<CustomerGameProfile, Long> {

//    @Query("select c from CustomerGameProfile c where c.login=:login and c.password = :password")
//    CustomerGameProfile findOne(@Param("login") String login, @Param("password") String password);
}
