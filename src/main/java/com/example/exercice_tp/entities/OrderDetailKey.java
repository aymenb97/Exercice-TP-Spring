package com.example.exercice_tp.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class OrderDetailKey implements Serializable {

    @Column(name = "item_id")
    private  Integer itemId;

    @Column(name = "order_id")
    private Integer orderId;
}
