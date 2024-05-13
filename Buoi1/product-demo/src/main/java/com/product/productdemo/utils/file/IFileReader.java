package com.product.productdemo.utils.file;

import com.product.productdemo.model.Product;

import java.util.List;

public interface IFileReader {
    List<Product> readFile(String filePath);
}