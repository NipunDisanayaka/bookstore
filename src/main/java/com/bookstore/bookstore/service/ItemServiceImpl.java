package com.bookstore.bookstore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.Item;
import com.bookstore.bookstore.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
       return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
       return itemRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Item not found : "+id));
    }

    @Override
    public Item createItem(Item item) {
      return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Long Id,Item item) {
      Item existingItem = getItemById(Id);

      existingItem.setTitle(item.getTitle());
      existingItem.setPrice(item.getPrice());
      existingItem.setQty(item.getQty());
      existingItem.setAuthor(item.getAuthor());
      existingItem.setDescription(item.getDescription());

      return itemRepository.save(existingItem);
    }

    @Override
    public void deleteItem(Long Id) {
      itemRepository.deleteById(Id);  
    }

    @Override
    public List<Item> getItemsByCategoryId(Long categoryId) {
       return itemRepository.findItemsByCategoryId(categoryId);
    }
    
}
