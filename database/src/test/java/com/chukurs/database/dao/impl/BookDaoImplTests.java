package com.chukurs.database.dao.impl;

import com.chukurs.database.domain.Author;
import com.chukurs.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        Book book = TestDataUtil.createTestBookA();
        underTest.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn,title,authorId) VALUES (?,?,?)"),
                eq("1234-5678-9098-1"), eq("The shadow in the attic A"), eq(1L));

    }

    @Test
    public void testThatFindOneBookGeneratesCorrectSql() {
        //as we get results FROM database, we need to map them to objects. (DAO pattern requires this, JPA would do it for us)
        underTest.findOne("123-456");
        verify(jdbcTemplate).query(
                eq("SELECT isbn,title,authorId FROM books WHERE isbn  = (?) LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("123-456"));

    }

    public void testThatFindBookGeneratesCorrectSql() {
        //as we get results FROM database, we need to map them to objects. (DAO pattern requires this, JPA would do it for us)
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT isbn,title,authorId FROM books "),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any());

    }

}
