package com.taxiservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

        @GetMapping("/registered")
        public ResponseEntity<String> registeredCustomer() {
            return ResponseEntity.ok("TEST");
        }
}
