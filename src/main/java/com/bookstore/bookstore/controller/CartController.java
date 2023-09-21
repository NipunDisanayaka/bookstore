package com.bookstore.bookstore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.entity.Cart;
import com.bookstore.bookstore.service.CartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/addToCart")
@EnableMethodSecurity
public class CartController {
    
    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCartItems(){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.getAllCartItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartItemById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.getCartItemById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Cart> getCartItemsByUserID(@PathVariable Long userId){
        try {
             return ResponseEntity.status(HttpStatus.OK).body(cartService.getCartItemById(userId));
            
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Cart> createCartItem(@RequestBody Cart cartItem){
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.createCartItem(cartItem));
    }

    
    // @GetMapping("/add/{itemId}")
    // public ResponseEntity<Cart> addToCart(@PathVariable Long itemId){
    //     return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addToCart(itemId));
    // }


    @DeleteMapping
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        try {
            cartService.deleteCartItem(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
