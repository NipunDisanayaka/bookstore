package com.bookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    
}
