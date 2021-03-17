package com.fptcustomer.demo.repositories;
import com.fptcustomer.demo.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("customersRepository")
public interface CustomersRepository extends JpaRepository<Customers, Long>  {
    Customers findByName(String name);
}
