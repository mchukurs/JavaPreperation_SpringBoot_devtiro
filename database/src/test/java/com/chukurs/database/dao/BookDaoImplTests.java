package com.chukurs.database.dao;

import com.chukurs.database.dao.impl.AuthorDaoImpl;
import com.chukurs.database.dao.impl.BookDaoImpl;
import com.chukurs.database.domain.Author;
import com.chukurs.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private BookDaoImpl underTest;


    @Test
    public void testThatCreateBookGeneratesCorrectSql() {
        Book book = Book.builder()
                .isbn("1234-5678-9098-7654")
                .title("The shadow in the attic")
                .authorId(1L)
                .build();
        underTest.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn,title,authorId) VALUES (?,?,?)"),
                eq("1234-5678-9098-7654"), eq("The shadow in the attic"), eq(1L));

    }
}
