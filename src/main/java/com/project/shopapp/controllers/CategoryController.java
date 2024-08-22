package com.project.shopapp.controllers;

import com.project.shopapp.dtos.CategoryDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
//    Hien thi tat ca categories
    @GetMapping("")
    public ResponseEntity<String> getAllCategories(@RequestParam("page") int page,
                                                   @RequestParam("limit") int limit){
        return ResponseEntity.ok(String.format("get all categories with page = %d, limit = %d", page, limit));
    }

    @PostMapping("")
    public ResponseEntity<String> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok("This is post cate " + categoryDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id){
        return ResponseEntity.ok("updated category with id = " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        return ResponseEntity.ok("deleted category with id = " + id);
    }
}
