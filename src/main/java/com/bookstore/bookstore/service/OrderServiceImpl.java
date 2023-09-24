package com.bookstore.bookstore.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.Cart;
import com.bookstore.bookstore.entity.Item;
import com.bookstore.bookstore.entity.Order;
import com.bookstore.bookstore.repository.ItemRepository;
import com.bookstore.bookstore.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Order createOrder(Order order) {
       return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
       return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Order not found : "+id));
    }

    @Override
    public void deleteAll() {
         orderRepository.deleteAll();
    }

    public Double getCartAmount(List<Cart> cartList){
        double totalCartAmount = 0;
        double singleCartAmount = 0;
        double availableQty = 0;

        for(Cart cart : cartList){
            Long itemId = cart.getItemId();
            Optional<Item> item = itemRepository.findById(itemId);
            if(item.isPresent()){
                Item item1 = item.get();
                if(item1.getAvailableQty() < cart.getQty()){
                    singleCartAmount = item1.getPrice()*item1.getAvailableQty();
                    // cart.setQty(item1.getAvailableQty());
                } else {
                    singleCartAmount = cart.getQty() * item1.getPrice();
                    availableQty = item1.getAvailableQty()-cart.getQty();
                }
                totalCartAmount=totalCartAmount+singleCartAmount;
                item1.setAvailableQty(availableQty);
                availableQty=0;
                //  cart.setItemName(item1.getTitle());
                //  cart.setAmount(singleCartAmount);
                itemRepository.save(item1);
            }
        }
        return totalCartAmount;
    } 
    
}
