package com.ksu.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public Flux<Payment> getAll(@PathVariable("id") Long customerId) {
        return paymentService.findAll(customerId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Payment> save(@RequestBody Payment payment) {
        return  paymentService.save(payment);
    }

}
