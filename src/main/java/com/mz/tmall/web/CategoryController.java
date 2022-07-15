package com.mz.tmall.web;

import com.mz.tmall.pojo.Category;
import com.mz.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> list(){
        return categoryService.list();
    }
}
