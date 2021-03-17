package com.fptcustomer.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name= "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="cust_id")
    private Long id;

    @Column(name="cust_name")
    @NotEmpty(message="* Please Enter Customer Name")
    private String name;

    @NotEmpty(message=" * Please Provide customer Address")
    @Column(name="cust_address")
    private String address;

}