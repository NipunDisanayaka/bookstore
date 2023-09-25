package com.bookstore.bookstore.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "shipping_details")
@Data
public class ShippingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String addressone;

    private String addresstwo;

    private String city;

    private String province;

    private String tp;

    private double totalAmount;

    @Column(updatable = false)
    private LocalDateTime createdAt;

      @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
       
    }



}
