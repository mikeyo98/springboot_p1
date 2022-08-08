package com.mz.tmall.web;

import com.mz.tmall.pojo.Category;
import com.mz.tmall.service.CategoryService;
import com.mz.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired CategoryService categoryService;


//    public List<Category> list(){
//        return categoryService.list();
//    }
    @GetMapping("/categories")
    public Page4Navigator<Category> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Category> page = categoryService.list(start, size, 5);
        return page;
    }
}
