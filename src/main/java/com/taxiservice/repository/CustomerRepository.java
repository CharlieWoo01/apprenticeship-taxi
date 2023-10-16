package com.taxiservice.repository;

import com.taxiservice.models.Customer;
import java.util.List;

public interface CustomerRepository {
    Customer findById(Long id);
    void save(Customer customer);
}

