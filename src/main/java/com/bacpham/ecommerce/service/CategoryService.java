package com.bacpham.ecommerce.service;

import com.bacpham.ecommerce.model.Category;
import com.bacpham.ecommerce.payload.CategoryDTO;
import com.bacpham.ecommerce.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize);
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
