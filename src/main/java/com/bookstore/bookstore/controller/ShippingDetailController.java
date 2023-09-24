package com.bookstore.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.dto.ShippingDetailDto;
import com.bookstore.bookstore.entity.ShippingDetails;
import com.bookstore.bookstore.service.ShippingDetailService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/shipping")
public class ShippingDetailController {
    
    @Autowired
    private ShippingDetailService shippingDetailService;

     @PostMapping
    public ResponseEntity<ShippingDetails> createCartItem(@RequestBody ShippingDetails details){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(shippingDetailService.saveDetails(details));
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
}
}
