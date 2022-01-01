package com.example.exercice_tp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String description;
    private Float price;
    private Float weight;


    @OneToMany(mappedBy = "itemDetail")
    private List<OrderDetail> details;
}
