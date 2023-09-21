package com.bookstore.bookstore.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long itemId;
    private String itemName;

    private Double qty;
    private Double amount;

    
    public Cart(Long itemId, String itemName,  Double qty,  Double amount) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.qty = qty;
        this.amount = amount;
    }


    public Cart(Long itemId,  Double qty) {
        this.itemId = itemId;
        this.qty = qty;
    }

    

}
