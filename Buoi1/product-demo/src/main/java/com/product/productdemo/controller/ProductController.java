package com.product.productdemo.controller;

import com.product.productdemo.model.Product;
import com.product.productdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        return product != null ?
                new ResponseEntity<>(product, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name-starts/{prefix}")
    public ResponseEntity<List<Product>> getProductsByNamePrefix(@PathVariable String prefix) {
        List<Product> products = productService.getProductsByNamePrefix(prefix);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/price/{min}/{max}")
    public ResponseEntity<List<Product>> getProductsByPriceRange(@PathVariable int min, @PathVariable int max) {
        List<Product> products = productService.getProductsByPriceRange(min, max);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable String brand) {
        List<Product> products = productService.getProductsByBrand(brand);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}/max-price")
    public ResponseEntity<Product> getMaxPriceProductByBrand(@PathVariable String brand) {
        Product product = productService.getMaxPriceProductByBrand(brand);
        return product != null ?
                new ResponseEntity<>(product, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
