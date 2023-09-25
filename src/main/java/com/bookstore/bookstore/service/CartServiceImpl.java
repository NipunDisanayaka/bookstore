package com.bookstore.bookstore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.Cart;
import com.bookstore.bookstore.repository.CartRepository;
@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepository cartRepository;

    @Override
    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();    
    }

    @Override
    public Cart createCartItem(Cart cartItem) {
       return cartRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(Long id) {
        cartRepository.deleteById(id);    
    }

    @Override
    public Cart getCartItemById(Long id) {
       return cartRepository.findById(id).orElseThrow(() -> new NoSuchElementException("CartItem not found : "+id));
    }

    @Override
    public void deleteAll() {
        cartRepository.deleteAll();
    }

    @Override
    public Boolean existByUserId(Long userId) {
       return cartRepository.existsByUserId(userId);
    }

    @Override
    public Boolean existByItemId(Long itemId) {
       return cartRepository.existsByItemId(itemId);
    }

    @Override
    public List<Cart> getCartByUserId(Long userId) {
       return cartRepository.getCartByUserId(userId);
    }

   @Override
   public void deleteCartsByUserId(Long userId) {
     cartRepository.deleteByUserId(userId);
   }

    // @Override
    // public List<Cart> findByUserId(Long id) {
    //    return cartRepository.findByUserId(id);
    // }

    // @Override
    // public List<Cart> findCartItemsByUserID(Long userId) {
    //    return cartRepository.findCartItemsByUserId(userId);
    // }
  
}