package com.chukurs.database.dao;

import com.chukurs.database.domain.Author;
import com.chukurs.database.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String isbn);
}
