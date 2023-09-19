package com.bookstore.bookstore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService{

   @Autowired
   CategoryRepository categoryRepository;
    
    @Override
    public List<Category> getAllCategories() {
      return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
      return categoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Item not found : "+id));
    }

    @Override
    public Category createCategory(Category category) {
      return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id,Category category) {
       Category existingCategory = getCategoryById(id);

       existingCategory.setName(category.getName());

       return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
    
}
