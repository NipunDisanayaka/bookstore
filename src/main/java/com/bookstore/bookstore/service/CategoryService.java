package com.bookstore.bookstore.service;

import java.util.List;

import com.bookstore.bookstore.entity.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Long id);
}
