package com.ksu.gameprofile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.ksu.gameprofile.model.Customer;
import com.ksu.gameprofile.model.CustomerInventory;
import com.ksu.gameprofile.model.Inventory;
import com.ksu.gameprofile.repository.CustomerInventoryRepository;
import com.ksu.gameprofile.service.exception.EntityNotFoundException;
import reactor.core.publisher.Mono;

@Service
public class CustomerInventoryService {

    private final CustomerInventoryRepository customerInventoryRepository;
    //todo cache
    private final InventoryService inventoryService;
    private final WebClient webClient;


    @Autowired
    public CustomerInventoryService(CustomerInventoryRepository customerInventoryRepository,
                                    InventoryService inventoryService,
                                    WebClient.Builder webClientBuilder) {
        this.customerInventoryRepository = customerInventoryRepository;
        this.inventoryService = inventoryService;
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
        ;
    }

    public CustomerInventory find(long customerId) {
        return customerInventoryRepository.findByCustomerId(customerId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public CustomerInventory save(CustomerInventory customerInventory) {
        inventoryService.find(customerInventory.getItemId());
        Customer customer = getCustomer(customerInventory.getCustomerId());

        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

       return customerInventoryRepository.save(customerInventory);
    }

    public Customer getCustomer(long customerId) {
        return this.webClient
                .get()
                .uri("/customer?customerId=" + customerId)
                .header("Content-Type", "application/json")
                .retrieve()
                .bodyToMono(Customer.class)
                .block();
    }
}
