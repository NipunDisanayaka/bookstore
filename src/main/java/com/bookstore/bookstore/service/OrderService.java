package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.Order;

@Service
public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
}
