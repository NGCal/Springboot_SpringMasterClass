package com.springbasics.web.springboot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @GetMapping(value = "/books")
    public List<Book> getBooks() {
        return Arrays.asList(new Book(1, "Pride and Prejudice", "Jane Austen"));
    }

}
