package com.joycevicentini.bookstoremanager.repository;

import com.joycevicentini.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
