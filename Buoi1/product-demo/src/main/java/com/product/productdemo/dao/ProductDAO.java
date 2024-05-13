package com.product.productdemo.dao;

import com.product.productdemo.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    Product getProductById(String id);
    List<Product> getProductsByNamePrefix(String prefix);
    List<Product> getProductsByPriceRange(int min, int max);
    List<Product> getProductsByBrand(String brand);
    Product getMaxPriceProductByBrand(String brand);
}
