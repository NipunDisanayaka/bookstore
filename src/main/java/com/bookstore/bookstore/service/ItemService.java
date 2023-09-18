package com.bookstore.bookstore.service;

import java.util.List;

import com.bookstore.bookstore.entity.Item;

public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(Long id);
    Item createItem(Item item);
    Item updateItem(Item item);
    void deleteItem(Item item);
    List<Item> getItemsByCategoryId(Long categoryId);
}
