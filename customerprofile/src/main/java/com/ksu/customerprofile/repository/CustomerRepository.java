package com.ksu.customerprofile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ksu.customerprofile.model.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("select c from Customer c where c.login=:login and c.password = :password")
    Customer findOne(@Param("login") String login, @Param("password") String password);

    Optional<Customer> findByCustomerId(long customerId);



}
