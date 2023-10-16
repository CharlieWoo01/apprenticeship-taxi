package com.taxiservice.repository.memory;

import com.taxiservice.models.Customer;
import com.taxiservice.repository.CustomerRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryMock implements CustomerRepository {

        private final Map<Long, Customer> customerMap = new HashMap<>();
        private Long nextId = 100L;

        @Override
        public Customer findById(Long id) {
            return customerMap.get(id);
        }

        @Override
        public void save(Customer customer) {
            if (customer.getId() == null) {
                customer.setId(nextId);
                nextId++;
            }
            customerMap.put(customer.getId(), customer);
        }
    }
