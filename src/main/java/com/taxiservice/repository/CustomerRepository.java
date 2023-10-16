package com.taxiservice.repository;

import com.taxiservice.models.Customer;

public interface CustomerRepository {
    Customer findById(Long id);
    void save(Customer customer);
}

