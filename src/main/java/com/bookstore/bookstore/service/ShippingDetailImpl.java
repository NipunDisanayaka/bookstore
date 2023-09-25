package com.bookstore.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.ShippingDetails;
import com.bookstore.bookstore.repository.ShippingDetailRepository;

@Service
public class ShippingDetailImpl implements ShippingDetailService {

    @Autowired
    ShippingDetailRepository shippingDetailRepository;

    @Override
    public ShippingDetails saveDetails(ShippingDetails detail) {
       return shippingDetailRepository.save(detail);
    }
    
}
