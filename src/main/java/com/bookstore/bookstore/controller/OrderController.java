package com.bookstore.bookstore.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.dto.OrderDto;
import com.bookstore.bookstore.dto.ResponceOrderDto;
import com.bookstore.bookstore.entity.Order;
import com.bookstore.bookstore.service.OrderService;
import com.bookstore.bookstore.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

     @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderById(id));
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<ResponceOrderDto> placeOrder(@RequestBody OrderDto orderDto){
        ResponceOrderDto responceOrderDto = new ResponceOrderDto();

        Double amount = orderService.getCartAmount(orderDto.getCartItems());

        //  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //  String username1 = auth.getName();

        Order order = new Order(amount);
        order = orderService.createOrder(order);

        responceOrderDto.setAmount(amount);
        responceOrderDto.setInvoiceNumber(new Random().nextInt(1000));
        responceOrderDto.setOrderId(order.getId());
        
        return ResponseEntity.status(HttpStatus.OK).body(responceOrderDto);


        
}
}
