package com.chukurs.database.dao;

import com.chukurs.database.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);
    Optional<Author> findOne(Long id);
}
