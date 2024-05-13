package com.product.productdemo.dao.impl;

import com.product.productdemo.dao.ProductDAO;
import com.product.productdemo.model.Product;
import com.product.productdemo.utils.file.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private IFileReader fileReader;

    @Override
    public List<Product> getAllProducts() {
        return fileReader.readFile("products.json");
    }

    @Override
    public Product getProductById(String id) {
        return getAllProducts().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> getProductsByNamePrefix(String prefix) {
        return getAllProducts().stream()
                .filter(product -> product.getName().startsWith(prefix))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByPriceRange(int min, int max) {
        return getAllProducts().stream()
                .filter(product -> product.getPrice() >= min && product.getPrice() <= max)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return getAllProducts().stream()
                .filter(product -> product.getBrand().equals(brand))
                .collect(Collectors.toList());
    }

    @Override
    public Product getMaxPriceProductByBrand(String brand) {
        return getProductsByBrand(brand).stream()
                .max((p1, p2) -> p1.getPrice() - p2.getPrice())
                .orElse(null);
    }
}
