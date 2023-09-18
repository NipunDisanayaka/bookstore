package com.bookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.entity.Order;

public interface OderRepository extends JpaRepository<Order,Long> {
    
}
