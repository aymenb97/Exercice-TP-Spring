package com.example.exercice_tp.entities;

import lombok.Getter;

@Getter
public enum OrderStatus {
    CREATE(0), SHIPPING(1), DELIVERED(2),PAID(3);

    @Getter private int val;

    private OrderStatus(int val) {
        val=val;
    }
}
