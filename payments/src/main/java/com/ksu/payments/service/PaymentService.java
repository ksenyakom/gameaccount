package com.ksu.payments.service;


import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ksu.payments.model.Payment;
import com.ksu.payments.repository.PaymentRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Value("${castomerprofile.url}")
    private String customerProfileUrl;

    public Flux<Payment> findAll(Long customerId) {
        return paymentRepository.findAllByCustomerId(customerId);
    }

    public Mono<Payment> save(Payment payment) {
        payment.setCreatedAt(ZonedDateTime.now().toString());
        return paymentRepository.save(payment);
    }
}
