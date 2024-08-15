package com.bacpham.ecommerce.service;

import com.bacpham.ecommerce.payload.CartDTO;

public interface CartService {
    CartDTO addProductToCart(Long productId, Integer quantity);
}
