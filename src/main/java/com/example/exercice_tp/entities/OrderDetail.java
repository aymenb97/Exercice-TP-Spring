package com.example.exercice_tp.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderDetail
{
    @EmbeddedId
     OrderDetailKey id;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
     Item itemDetail;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
     Order orderDetail;

    private  Integer qty;

    private Float tax;
}
