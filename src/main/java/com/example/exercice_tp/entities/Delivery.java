package com.example.exercice_tp.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String deliveryMan;
    private LocalDate shoppingDate;
    private LocalDate deliveryDate;

    @ManyToOne
    private Order order;
}
