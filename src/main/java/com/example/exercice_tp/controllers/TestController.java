package com.example.exercice_tp.controllers;

import ch.qos.logback.core.net.server.Client;
import com.example.exercice_tp.entities.Customer;
import com.example.exercice_tp.entities.Delivery;
import com.example.exercice_tp.repositories.CustomerRepository;
import com.example.exercice_tp.repositories.DeliveryRepository;
import com.example.exercice_tp.repositories.OrderDetailRepository;
import com.example.exercice_tp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TestController {

    private final OrderDetailRepository orderDetailRepository;
    private final DeliveryRepository deliveryRepository;
    private final CustomerRepository customerRepository;

    TestController(OrderDetailRepository orderRepository,DeliveryRepository deliveryRepository,CustomerRepository customerRepository) {
        this.orderDetailRepository = orderRepository;
        this.deliveryRepository= deliveryRepository;
        this.customerRepository=customerRepository;
    }
    @GetMapping("/total/{id}")
    private Float calculateTotal(@PathVariable Integer id){
        return orderDetailRepository.calculateTotal(id);
    }

    @GetMapping("/weight/{id}")
    private Float calculateWeight(@PathVariable Integer id){
        return orderDetailRepository.calculateWeight(id);
    }

    @GetMapping("/deliverymin")
    private String deliveryMin(){
        return deliveryRepository.deliveryMin();
    }

    @GetMapping("/deliverymax")
    private String deliveryMax(){
        return deliveryRepository.deliveryMax();
    }

    @GetMapping("/customers")
    private List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/topcustomersbyorder")
    private List<Customer> topFiveByOrder(){
        return customerRepository.topFiveByOrder();
    }

    @GetMapping("/topcustomersbyspending")
    private List<Customer> topFiveBySpending(){
        return customerRepository.topFiveBySpending();
    }

    @GetMapping("/customersweight/{start}/{end}")
    private  List<Customer> customerOrderWeight(@PathVariable("start") String start,@PathVariable("end") String end){
        return customerRepository.ordersOverTen(start,end);
    }

}
