package com.joycevicentini.bookstoremanager.controller;

import com.joycevicentini.bookstoremanager.dto.BookDTO;
import com.joycevicentini.bookstoremanager.dto.MessageResponseDTO;
import com.joycevicentini.bookstoremanager.exception.BookNotFoundException;
import com.joycevicentini.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }
}
