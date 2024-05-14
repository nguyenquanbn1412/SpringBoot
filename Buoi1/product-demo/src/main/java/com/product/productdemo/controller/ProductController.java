package com.product.productdemo.controller;

import com.product.productdemo.model.Product;
import com.product.productdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/detail/{id}")
    public String getProductById(Model model, @PathVariable String id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product-detail";
    }

    @GetMapping("/name-starts/{prefix}")
    public String getProductsByNamePrefix(Model model, @PathVariable String prefix) {
        List<Product> products = productService.getProductsByNamePrefix(prefix);
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/price/{min}/{max}")
    public String getProductsByPriceRange(Model model, @PathVariable int min, @PathVariable int max) {
        List<Product> products = productService.getProductsByPriceRange(min, max);
        model.addAttribute("products", products);
        return "product-price-range";
    }

    @GetMapping("/brand/{brand}")
    public String getProductsByBrand(Model model, @PathVariable String brand) {
        List<Product> products = productService.getProductsByBrand(brand);
        model.addAttribute("products", products);
        return "product-brand";
    }

    @GetMapping("/brand/{brand}/max-price")
    public String getMaxPriceProductByBrand(Model model, @PathVariable String brand) {
        Product product = productService.getMaxPriceProductByBrand(brand);
        model.addAttribute("product", product);
        return "max-price-product";
    }
}
