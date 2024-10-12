package com.ksu.payments.service;


import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.ksu.payments.model.Customer;
import com.ksu.payments.model.Payment;
import com.ksu.payments.repository.PaymentRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PaymentService {

//    public static final int ITERATIOIN_NUMBER = 1;

    @Autowired
    private PaymentRepository paymentRepository;

    @Value("${castomerprofile.url}")
    private String customerProfileUrl;

//    public Mono<Payment> find(String login, String password) {
//        String hashedPassword = HashUtils.hash512(password, ITERATIOIN_NUMBER);
//        return customerRepository.findOne(login, hashedPassword);
//    }
//
//    public Mono<Payment> saveCustomer(Payment customer) {
//        String hashedPassword = HashUtils.hash512(customer.getPassword(), ITERATIOIN_NUMBER);
//        customer.setPassword(hashedPassword);
//
//        return customerRepository.save(customer);
//    }

    public Flux<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Mono<Payment> save(Payment payment) {
        Customer customer = WebClient.create(customerProfileUrl).get() //todo cходить за кастомером в другой сервис
                .uri("/customer/{id}", payment.getCustomerId())
                .retrieve()
                .bodyToMono(Customer.class)
                .block(); //todo set time?
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        payment.setCreatedAt(ZonedDateTime.now());
        return paymentRepository.save(payment);
    }

//    public Flux<String> findAllEmails() {
//        return customerRepository.findAllEmails();
//    }

}
