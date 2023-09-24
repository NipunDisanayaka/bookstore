package com.bookstore.bookstore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.dto.ItemImageDto;
import com.bookstore.bookstore.entity.Item;
import com.bookstore.bookstore.service.ItemService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/items")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(itemService.getItemById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        }
    }

    @GetMapping("/subCategory/{id}")
    public ResponseEntity<List<Item>> getItemBySubCategoryId(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(itemService.getItemsBySubCategoryId(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        }
    }

    @PostMapping
    public ResponseEntity<Item> saveUSer(@RequestBody Item item){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(itemService.createItem(item));
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id,Item item){
       
        try {
            Item updatedItem = itemService.updateItem(id, item);
            return ResponseEntity.status(HttpStatus.OK).body(updatedItem);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
}

     @PostMapping("/{id}/item")
    public ResponseEntity<Item> updateProfile(@PathVariable Long id, @ModelAttribute ItemImageDto itemImageDto) {
        return new ResponseEntity<Item>(itemService.updateItemImage(id, itemImageDto), HttpStatus.OK);
    }



@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    try {
        itemService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
}
