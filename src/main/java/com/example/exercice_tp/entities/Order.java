package com.example.exercice_tp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private LocalDate createDate;

    @ManyToOne
    @Getter(AccessLevel.NONE)
    private Customer customer;

    @JsonBackReference
    public Customer getCustomer() {
        return customer;
    }

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order")
    private List<Delivery> deliveries;

    @OneToMany(mappedBy = "orderDetail")
    private  List<OrderDetail> details;

}
