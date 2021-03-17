package com.fptcustomer.demo.services;

import com.fptcustomer.demo.entity.Customers;
import com.fptcustomer.demo.repositories.CustomersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServices {
  @Autowired
  private CustomersRepository customersRepository;

  public Customers findByName(String name) {
    return customersRepository.findByName(name);
  }

  public List<Customers> getAllCustomers() {
    return customersRepository.findAll();
  }

  public Customers saveCustomers(Customers Customers) {
    return customersRepository.save(Customers);
  }

  public Customers updateCustomers(Customers Customers, Long id) {
    Customers updateCustomers = customersRepository.findById(id).orElse(null);
    if (updateCustomers != null) {
      updateCustomers.setName(Customers.getName());
    }
    final Customers myCustomers = customersRepository.save(updateCustomers);
    return myCustomers;
  }

  public Boolean deleteCustomers(Long id) {
    Customers delCustomers = customersRepository.findById(id).orElse(null);
    if (delCustomers != null) {
      customersRepository.delete(delCustomers);
      return true;
    }
    return false;
  }
}
