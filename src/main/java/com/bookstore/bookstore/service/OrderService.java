package com.bookstore.bookstore.service;

import java.util.List;

import com.bookstore.bookstore.entity.Order;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
}
