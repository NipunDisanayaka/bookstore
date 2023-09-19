package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.SubCategory;

@Service
public interface SubCategoryService {
    List<SubCategory> getAllCategories();
    SubCategory getCategoryById(Long id);
    SubCategory createCategory(SubCategory subCategory);
    SubCategory updateCategory(Long id,SubCategory subCategory);
    void deleteCategory(Long id);
}
