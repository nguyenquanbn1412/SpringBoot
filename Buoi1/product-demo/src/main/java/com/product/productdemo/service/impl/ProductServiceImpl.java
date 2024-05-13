package com.product.productdemo.service;

import com.product.productdemo.dao.ProductDAO;
import com.product.productdemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(String id) {
        return productDAO.getProductById(id);
    }

    @Override
    public List<Product> getProductsByNamePrefix(String prefix) {
        return productDAO.getProductsByNamePrefix(prefix);
    }

    @Override
    public List<Product> getProductsByPriceRange(int min, int max) {
        return productDAO.getProductsByPriceRange(min, max);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productDAO.getProductsByBrand(brand);
    }

    @Override
    public Product getMaxPriceProductByBrand(String brand) {
        return productDAO.getMaxPriceProductByBrand(brand);
    }
}
