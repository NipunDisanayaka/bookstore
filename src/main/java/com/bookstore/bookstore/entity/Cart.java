package com.bookstore.bookstore.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = { "item_name", "user_id" }))
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;

    private Double qty;
    private Double amount;

    @Column(nullable = true)
    private Double availableQty;

     @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") //Foreign key of User Entity
    private User user;

    
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
