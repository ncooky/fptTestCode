package com.fptcustomer.demo.controllers;

import com.fptcustomer.demo.entity.Customers;
import com.fptcustomer.demo.services.CustomerServices;
import java.util.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
  @Autowired
  private CustomerServices customerService;

  @GetMapping("/customers")
  public List<Customers> all() {
    return customerService.getAllCustomers();
  }

  @PostMapping("/customers")
  public ResponseEntity<Customers> createCustomer(
    @Valid @RequestBody Customers customer
  ) {
    return ResponseEntity.ok(customerService.saveCustomers(customer));
  }

  @PutMapping("/customers/{id}")
  public ResponseEntity<Customers> updateCustomer(
    @Valid @RequestBody Customers customer,
    @PathVariable(value = "id") Long id
  ) {
    return ResponseEntity.ok(customerService.updateCustomers(customer, id));
  }

  @DeleteMapping("/customers/{id}")
  public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
    Map<String, String> response = new HashMap<String, String>();
    if (customerService.deleteCustomers(id)) {
      response.put("status", "success");
      response.put("message", "customer deleted successfully");
      return ResponseEntity.ok(response);
    } else {
      response.put("status", "error");
      response.put("message", "Somthing went wrong when delete the member");
      return ResponseEntity.status(500).body(response);
    }
  }
}
