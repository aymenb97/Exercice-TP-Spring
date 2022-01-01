package com.example.exercice_tp.repositories;

import com.example.exercice_tp.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    @Query(nativeQuery = true,value="SELECT SUM((I.price*O.qty)+O.tax) from item I, order_detail O WHERE I.id=O.item_id and O.order_id=:id")
    public Float calculateTotal(@Param("id") Integer id);

    @Query(nativeQuery = true,value="SELECT SUM((I.weight*O.qty)) from item I, order_detail O WHERE I.id=O.item_id and O.order_id=:id")
    public Float calculateWeight(@Param("id") Integer id);

}
