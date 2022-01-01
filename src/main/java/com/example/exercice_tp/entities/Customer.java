package com.example.exercice_tp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "customer")
    @Getter(AccessLevel.NONE)
    private List<Order> orders;
    private String name;
    private String deliveryAddress;
    private String contact;
    private Boolean active;

    @JsonIgnore
    public List<Order> getOrders() {
        return this.orders;
    }

}
