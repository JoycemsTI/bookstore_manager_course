package com.joycevicentini.bookstoremanager.service;

import com.joycevicentini.bookstoremanager.dto.AuthorDTO;
import com.joycevicentini.bookstoremanager.dto.BookDTO;
import com.joycevicentini.bookstoremanager.dto.MessageResponseDTO;
import com.joycevicentini.bookstoremanager.entity.Author;
import com.joycevicentini.bookstoremanager.entity.Book;
import com.joycevicentini.bookstoremanager.exception.BookNotFoundException;
// import com.joycevicentini.bookstoremanager.mapper.BookMapper;
import com.joycevicentini.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    // private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {
        Author authorToSave = Author.builder()
                .name(bookDTO.getAuthor().getName())
                .age(bookDTO.getAuthor().getAge())
                .build();
        Book bookToSave = Book.builder() // bookMapper.toModel(bookDTO)
                .name(bookDTO.getName())
                .pages(bookDTO.getPages())
                .chapters(bookDTO.getChapters())
                .isbn(bookDTO.getIsbn())
                .publisherName(bookDTO.getPublisherName())
                .author(authorToSave)
                .build();
        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book Created with ID " + savedBook.getId())
                .build();
    }

    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        AuthorDTO authorDTO = AuthorDTO.builder()
                .id(book.getAuthor().getId())
                .name(book.getAuthor().getName())
                .age(book.getAuthor().getAge())
                .build();
        BookDTO bookDTO = BookDTO.builder()
                .id(book.getId())
                .name(book.getName())
                .pages(book.getPages())
                .chapters(book.getChapters())
                .isbn(book.getIsbn())
                .publisherName(book.getPublisherName())
                .author(authorDTO)
                .build();
        return bookDTO; // bookMapper.toDTO(book)
    }
}
