package com.example.exercice_tp.repositories;

import com.example.exercice_tp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
