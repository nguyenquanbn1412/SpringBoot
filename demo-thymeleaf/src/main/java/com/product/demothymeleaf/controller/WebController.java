package com.product.demothymeleaf.controller;

import com.product.demothymeleaf.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    private final List<Book> books;
    public WebController() {
        books = new ArrayList<>();
        books.add(new Book(1, "Gone with the wind", "Cuong", 1945));
        books.add(new Book(2, "Chi Dau", "Nam Cao", 1943));
    }

    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("book", books.get(0));
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/blog")
    public String getBlog(){
        return "admin/blog";
    }
}
