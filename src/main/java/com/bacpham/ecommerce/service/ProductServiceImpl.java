package com.bacpham.ecommerce.service;

import com.bacpham.ecommerce.exceptions.ResourceNotFoundException;
import com.bacpham.ecommerce.model.Category;
import com.bacpham.ecommerce.model.Product;
import com.bacpham.ecommerce.payload.ProductDTO;
import com.bacpham.ecommerce.repositories.CategoryRepository;
import com.bacpham.ecommerce.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO addProduct(Long categoryId, Product product) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category", "categoryId", categoryId));
        product.setImage("default.png");
        product.setCategory(category);
        double specialPrice = (1 - product.getDiscount() * 0.01) * product.getPrice();
        product.setSpecialPrice(specialPrice);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }
}
