package com.bookstore.bookstore.dto;


import lombok.Data;

@Data
public class ItemDto {
    private String title;

    private Double price;

    private Double qty;

    private String author;

    private String description;


}
