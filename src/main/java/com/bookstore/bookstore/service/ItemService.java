package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore.dto.ItemImageDto;
import com.bookstore.bookstore.entity.Item;

@Service
public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(Long id);
    Item createItem(Item item);
    Item updateItem(Long id, Item itemDto);
    void deleteItem(Long id);
    List<Item> getItemsByCategoryId(Long categoryId);
    Item updateItemImage(Long id,ItemImageDto itemImage);
    List<Item> getItemsBySubCategoryId(Long subCategoryId);
}
