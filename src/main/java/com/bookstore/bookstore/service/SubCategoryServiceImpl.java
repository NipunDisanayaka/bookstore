package com.bookstore.bookstore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.SubCategory;
import com.bookstore.bookstore.repository.SubCategoryRepository;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategory> getAllCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory getCategoryById(Long id) {
       return subCategoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Item not found : "+id));
    }

    @Override
    public SubCategory createCategory(SubCategory subCategory) {
      return subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategory updateCategory(Long id, SubCategory subCategory) {
       SubCategory existingSubCategory = getCategoryById(id);
       
       existingSubCategory.setName(subCategory.getName());

       return subCategoryRepository.save(existingSubCategory);
    }

    @Override
    public void deleteCategory(Long id) {
      subCategoryRepository.deleteById(id); 
    }
    
}
