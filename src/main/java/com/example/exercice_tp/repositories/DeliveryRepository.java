package com.example.exercice_tp.repositories;

import com.example.exercice_tp.entities.Delivery;
import com.example.exercice_tp.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    @Query(nativeQuery = true,value = "SELECT delivery_man from delivery D GROUP BY delivery_man ORDER BY avg(D.delivery_date-D.shopping_date) ASC LIMIT 1")
    public String deliveryMin();

    @Query(nativeQuery = true,value = "SELECT delivery_man from delivery D GROUP BY delivery_man ORDER BY avg(D.delivery_date-D.shopping_date) DESC LIMIT 1")
    public String deliveryMax();
}
