package com.fsrg.mycrud.controllers;

import com.fsrg.mycrud.model.Book;
import com.fsrg.mycrud.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private final BookService service;

    public BookController(BookService bookService){
        this.service = bookService;
    }
    @GetMapping("/book")
    public List<Book> getAllBooks(){
        return this.service.getAllBooks();
    }

    @PostMapping("/book")
    public long createBook(@RequestBody Book book){
        return this.service.createBook(book);

    }
}
