package com.bookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.entity.User;


public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
