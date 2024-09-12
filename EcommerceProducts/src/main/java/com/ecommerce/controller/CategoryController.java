package com.ecommerce.controller;

import com.ecommerce.entity.Category;
import com.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    

    @GetMapping("/all")
    public List<Category> getAllCategory() {
       return categoryService.getAllCategories();
        
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Category> getcategoryById(@PathVariable("id") Long categoryId){
        Category category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
        
}
