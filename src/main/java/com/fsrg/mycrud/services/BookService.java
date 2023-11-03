package com.fsrg.mycrud.services;

import com.fsrg.mycrud.model.Book;
import com.fsrg.mycrud.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository bookRepository){
        this.repository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return repository.getAllBooks();
    }

    public long createBook(Book book) {
        return repository.createBook(book);
    }
}
