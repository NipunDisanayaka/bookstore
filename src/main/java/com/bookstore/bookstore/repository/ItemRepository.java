package com.bookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {
    
}
