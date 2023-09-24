package com.bookstore.bookstore.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "user_id") //Foreign key of User Entity
    // private User user;

    private Double totalAmount;


    // @ManyToMany(targetEntity = Item.class, cascade = { CascadeType.ALL}, fetch = FetchType.EAGER)
    // @JoinTable(
    //     name = "order_items",
    //     joinColumns = { @JoinColumn(name = "order_id")},
    //     inverseJoinColumns = { @JoinColumn(name = "item_id") }
    // )
    //  Set<Item> items;

    //  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Cart.class)
    // @JoinColumn(name = "order_id", referencedColumnName = "id")
    // private List<Cart> cartItems;


    //Get the system time on Order create and update
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
       
    }

    public Order(Double totalAmount) {
        this.totalAmount=totalAmount;
    }

    

}
