package com.taxiservice.services;

import com.taxiservice.models.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    ResponseEntity<Customer> registerCustomer(Customer customer);
    ResponseEntity<Customer> getRegisteredCustomer(Long id);
}
