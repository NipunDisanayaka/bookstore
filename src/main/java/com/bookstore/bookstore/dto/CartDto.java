package com.bookstore.bookstore.dto;

import com.bookstore.bookstore.entity.Item;
import com.bookstore.bookstore.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private Item item;

    private User user;
}
