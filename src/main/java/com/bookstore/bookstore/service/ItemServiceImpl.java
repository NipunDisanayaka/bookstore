package com.bookstore.bookstore.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bookstore.bookstore.dto.ItemImageDto;
import com.bookstore.bookstore.entity.Item;
import com.bookstore.bookstore.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Value("${upload.directory}")
    private String uploadDirectory;

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
      existingItem.setAvailableQty(item.getAvailableQty());
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

    @Override
    public Item updateItemImage(Long id, ItemImageDto itemImage) {
       Item existingItem = itemRepository.findById(id).orElse(null);

        if(existingItem != null) {
            
            MultipartFile file = itemImage.getItemImage();
            String filename = file.getOriginalFilename();
            String filePath = uploadDirectory + File.separator + filename;

            try {
                file.transferTo(new File(filePath));
            } catch (IllegalStateException e) {
                
                e.printStackTrace();
            } catch (IOException e) {
                
                e.printStackTrace();
            }

            existingItem.setImage(filename);;
            return itemRepository.save(existingItem);
        }

        return null;
    }

    @Override
    public List<Item> getItemsBySubCategoryId(Long subCategoryId) {
     return itemRepository.getItemsBySubCategoryId(subCategoryId);
    }
    
}
