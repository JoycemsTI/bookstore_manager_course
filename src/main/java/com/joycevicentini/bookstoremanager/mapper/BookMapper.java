package com.joycevicentini.bookstoremanager.mapper;

import com.joycevicentini.bookstoremanager.dto.BookDTO;
import com.joycevicentini.bookstoremanager.entity.Book;
import org.mapstruct.Mapper;
// import org.mapstruct.factory.Mappers;


public interface BookMapper {

   // BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toModel(BookDTO bookDTO); //teste

    BookDTO toDTO(Book book);
}
