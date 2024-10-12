package com.ksu.payments.controller;

import java.awt.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ksu.payments.model.Payment;
import com.ksu.payments.service.PaymentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/payments")
public class PaymentsController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public Flux<Payment> getAll() {
        return paymentService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Payment> save(@RequestBody Payment payment) {
        return  paymentService.save(payment);
    }

//    @GetMapping
//    public Flux<String> getAllEmails() {
//        return customerService.findAllEmails();
//    }

//    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Mono<Payment> login(@RequestBody Payment payment) {
//        return customerService.find(payment.getLogin(), payment.getPassword()).map(CustomerDto::new);
//    }
//
//    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity register(@RequestBody Payment payment) {
//        customerService.saveCustomer(payment);
//        return new ResponseEntity(HttpStatus.CREATED);
//    }

}
