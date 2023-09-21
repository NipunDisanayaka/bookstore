package com.bookstore.bookstore.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ResponceOrderDto {
    private Double amount;
    private int invoiceNumber;
    private Date date;
    private Long orderId;
}
