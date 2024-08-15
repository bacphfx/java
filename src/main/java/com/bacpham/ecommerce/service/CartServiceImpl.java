package com.bacpham.ecommerce.service;

import com.bacpham.ecommerce.model.Cart;
import com.bacpham.ecommerce.payload.CartDTO;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    @Override
    public CartDTO addProductToCart(Long productId, Integer quantity) {
        Cart cart = createCart();
        return null;
    }

    private Cart createCart() {
    }
}
