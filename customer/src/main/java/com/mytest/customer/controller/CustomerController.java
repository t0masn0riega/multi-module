package com.mytest.customer.controller;

import com.mytest.common.models.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

  private List<Customer> customers;

  @PostConstruct
  public void init() {
    customers = new ArrayList<>();
    customers.add(new Customer(UUID.randomUUID(), "Customer Name_" + 0));
    customers.add(new Customer(UUID.randomUUID(), "Customer Name_" + 1));
    customers.add(new Customer(UUID.randomUUID(), "Customer Name_" + 2));
    customers.add(new Customer(UUID.randomUUID(), "Customer Name_" + 3));
    customers.add(new Customer(UUID.randomUUID(), "Customer Name_" + 4));
    customers.add(new Customer(UUID.randomUUID(), "Customer Name_" + 5));
  }

  @GetMapping
  public ResponseEntity<List<Customer>> search() {
    return new ResponseEntity<>(customers, HttpStatus.OK);
  }

}
