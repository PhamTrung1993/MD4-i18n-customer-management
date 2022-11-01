package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "provices")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;

    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customers;

    public Province() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
