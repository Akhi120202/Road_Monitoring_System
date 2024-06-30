package com.example.report_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.report_service.model.Category;
import com.example.report_service.service.CategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api/report/category")
@RequiredArgsConstructor
public class CategoryController {
    public final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategory(@RequestBody Category category) {
       categoryService.addCategory(category);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    
    
}
