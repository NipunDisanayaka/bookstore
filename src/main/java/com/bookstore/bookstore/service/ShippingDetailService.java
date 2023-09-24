package com.bookstore.bookstore.service;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore.dto.ShippingDetailDto;
import com.bookstore.bookstore.entity.ShippingDetails;

@Service
public interface ShippingDetailService   {
    ShippingDetails saveDetails(ShippingDetails detail);
}
