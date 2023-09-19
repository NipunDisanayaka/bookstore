package com.bookstore.bookstore.entity;


import java.util.HashSet;
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
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "items")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double qty;

    @Column(nullable = true)
    private String author;

    @Column(nullable = true)
    private String description;

    //  @ManyToMany(cascade = { CascadeType.ALL}, fetch = FetchType.EAGER)
    // @JoinTable(
    //     name = "order_items",
    //     joinColumns = @JoinColumn(name = "order_id"),
    //     inverseJoinColumns = { @JoinColumn(name = "item_id") }
    // )
    // private Set<Item> items;

    @ManyToMany(mappedBy = "items")
     Set<Order> orders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Subcategory_id") //Foreign Key of Category
    private SubCategory subCategory;

}
