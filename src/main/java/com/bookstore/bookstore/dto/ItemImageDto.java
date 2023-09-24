package com.bookstore.bookstore.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class ItemImageDto {
    private  MultipartFile itemImage;
}
