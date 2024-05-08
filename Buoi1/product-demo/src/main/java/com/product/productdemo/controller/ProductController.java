package com.product.productdemo.controller;
import com.product.productdemo.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    private static final List<Product> products = Arrays.asList(
            new Product("1235", "iPhone 13", "Enhanced performance and better battery life than its predecessor.", 1099, "Apple"),
            new Product("1236", "Samsung Galaxy Note 20", "High-end device with S Pen for productivity and large display.", 999, "Samsung"),
            new Product("1237", "Google Pixel 5", "Compact, yet powerful device with excellent camera and stock Android.", 699, "Google"),
            new Product("1238", "OnePlus 9", "Powerful performance with Hasselblad camera for enhanced photo quality.", 729, "OnePlus"),
            new Product("1239", "Xiaomi Mi 11", "Top-tier performance with innovative features at a competitive price.", 749, "Xiaomi")
    );

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return products;
    }
}

