package com.chukurs.database.dao;

import com.chukurs.database.domain.Author;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(Long id);

    List<Author> find();
}
