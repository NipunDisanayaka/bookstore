package com.bookstore.bookstore.dto;

import java.util.List;

import com.bookstore.bookstore.entity.Cart;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class OrderDto {
    private List<Cart> cartItems;
}
