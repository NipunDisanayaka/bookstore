package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore.dto.CartQtyDto;
import com.bookstore.bookstore.entity.Cart;

@Service
public interface CartService {
    List<Cart> getAllCartItems();
    Cart createCartItem(Cart cartItem);
    Cart getCartItemById(Long id);
    void deleteCartItem(Long id);
    void deleteAll();
    Boolean existByUserId(Long userId);
    Boolean existByItemId(Long itemId);
    List<Cart> getCartByUserId(Long userId);
    void deleteCartsByUserId(Long userId);
    Cart updateCart(Long id, CartQtyDto cartQtyDto);
    // List<Cart> findByUserId(Long id);
    // List<Cart> findCartItemsByUserID(Long userId);
    // Cart addToCart(Long itemId);

}
