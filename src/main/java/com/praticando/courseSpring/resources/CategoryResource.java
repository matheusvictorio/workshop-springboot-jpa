package com.praticando.courseSpring.resources;

import com.praticando.courseSpring.entities.Category;
import com.praticando.courseSpring.entities.User;
import com.praticando.courseSpring.services.CategoryService;
import com.praticando.courseSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {


    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@org.springframework.web.bind.annotation.PathVariable Long id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }
}
