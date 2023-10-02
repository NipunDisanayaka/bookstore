package com.bookstore.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.entity.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("SELECT item FROM Item item WHERE item.subCategory.category.id = :categoryId")
    List<Item> findItemsByCategoryId(@Param("categoryId") Long categoryId);

    List<Item> getItemsBySubCategoryId(Long subCategoryId);
    
}
