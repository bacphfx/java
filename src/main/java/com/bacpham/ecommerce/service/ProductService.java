package com.bacpham.ecommerce.service;

import com.bacpham.ecommerce.model.Product;
import com.bacpham.ecommerce.payload.ProductDTO;

public interface ProductService {

    ProductDTO addProduct(Long categoryId, Product product);
}
