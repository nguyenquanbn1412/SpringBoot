package com.product.productdemo.database;

import com.product.productdemo.utils.file.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDB implements CommandLineRunner {
    @Autowired
    private IFileReader fileReader;

    @Override
    public void run(String... args) throws Exception {
        ProductDB.products = fileReader.readFile("products.json");

        System.out.println("Số lượng Products = " + ProductDB.products.size());
    }
}
