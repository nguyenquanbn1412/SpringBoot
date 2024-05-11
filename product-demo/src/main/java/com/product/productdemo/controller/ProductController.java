package com.product.productdemo.controller;
import com.product.productdemo.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private static final List<Product> products = Arrays.asList(
            new Product("1235", "iPhone 13", "Enhanced performance and better battery life than its predecessor.", 1099, "Apple"),
            new Product("1236", "Samsung Galaxy Note 20", "High-end device with S Pen for productivity and large display.", 999, "Samsung"),
            new Product("1237", "Google Pixel 5", "Compact, yet powerful device with excellent camera and stock Android.", 699, "Google"),
            new Product("1238", "OnePlus 9", "Powerful performance with Hasselblad camera for enhanced photo quality.", 729, "OnePlus"),
            new Product("1239", "Xiaomi Mi 11", "Top-tier performance with innovative features at a competitive price.", 749, "Xiaomi"),
            new Product("1240", "Xiaomi Mi 13T Pro", "Top of Xiaomi.", 899, "Xiaomi")
    );

    //BTVN Buoi 1
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return products;
    }

    //BTVN Buoi 2
     @GetMapping("/products/{id}")
        public Product getProductById(@PathVariable String id) {
            return products.stream()
                    .filter(product -> product.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }

        @GetMapping("/products/name-starts/{prefix}")
        public List<Product> getProductsByNamePrefix(@PathVariable String prefix) {
            return products.stream()
                    .filter(product -> product.getName().startsWith(prefix))
                    .collect(Collectors.toList());
        }

        @GetMapping("/products/price/{min}/{max}")
        public List<Product> getProductsByPriceRange(@PathVariable int min, @PathVariable int max) {
            return products.stream()
                    .filter(product -> product.getPrice() >= min && product.getPrice() <= max)
                    .collect(Collectors.toList());
        }

        @GetMapping("/products/brand/{brand}")
        public List<Product> getProductsByBrand(@PathVariable String brand) {
            return products.stream()
                    .filter(product -> product.getBrand().equals(brand))
                    .collect(Collectors.toList());
        }

        @GetMapping("/products/brand/{brand}/max-price")
        public Product getMaxPriceProductByBrand(@PathVariable String brand) {
            return products.stream()
                    .filter(product -> product.getBrand().equals(brand))
                    .max(Comparator.comparing(Product::getPrice))
                    .orElse(null);
        }
}

