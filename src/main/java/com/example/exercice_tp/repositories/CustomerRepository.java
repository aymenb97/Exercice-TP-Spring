package com.example.exercice_tp.repositories;

import ch.qos.logback.core.net.server.Client;
import com.example.exercice_tp.entities.Customer;
import org.hibernate.usertype.CompositeUserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    @Query(nativeQuery = true,value = "SELECT C.* FROM customer C INNER JOIN order_table T ON C.id= T.customer_id GROUP BY T.customer_id ORDER BY COUNT(*) DESC LIMIT 5")
    public List<Customer> topFiveByOrder();

    @Query(nativeQuery = true,value = "SELECT C.* FROM Item I, order_detail D, order_table O, customer C WHERE I.id=D.item_id AND D.order_id=O.id AND o.customer_id=c.id GROUP BY O.customer_id ORDER BY SUM(I.price*D.qty+tax) DESC LIMIT 5")
    public  List<Customer> topFiveBySpending();

    @Query(nativeQuery = true,value = "SELECT C.* FROM customer c WHERE c.id IN (SELECT C.id FROM Item I, order_detail D, order_table O, customer C WHERE I.id=D.item_id AND D.order_id=O.id AND o.customer_id=c.id AND O.create_date BETWEEN :start and :end GROUP BY C.id HAVING SUM(D.qty*I.weight) > 10)")
    public  List<Customer> ordersOverTen(@Param("start") String startDate,@Param("end") String endDate);

}
