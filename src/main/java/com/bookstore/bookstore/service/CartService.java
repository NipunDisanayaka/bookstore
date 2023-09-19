package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.Cart;

@Service
public interface CartService {
    List<Cart> getAllCartItems();
    Cart createCartItem(Cart cartItem);
    Cart getCartItemById(Long id);
    void deleteCartItem(Long id);
}
