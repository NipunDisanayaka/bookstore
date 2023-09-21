package com.bookstore.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.entity.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    // @Query("SELECT cart FROM Cart cart WHERE cart.user.id = :userId")
    // List<Cart> findCartItemsByUserId(@Param("userId") Long userId);

}
