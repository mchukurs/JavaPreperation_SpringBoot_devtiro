package com.chukurs.database.dao.impl;

import com.chukurs.database.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatDeleteAuthorGeneratesCorrectSql() {
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.delete(authorA.getId());
        verify(jdbcTemplate).update(
                "DELETE FROM authors WHERE id = ?",
                1L);
    }

    @Test
    public void testThatUpdateAuthorGeneratesCorrectSql() {
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.update(authorA.getId(), authorA);
        verify(jdbcTemplate).update(
                "UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?",
                1L, "Abigail Rose A", 81, 1L);
    }

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql() {
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.create(authorA);
        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?,?,?)"),
                eq(1L), eq("Abigail Rose A"), eq(81));

    }

    @Test
    public void testThatFindOneGeneratesCorrectSql() {
        //as we get results FROM database, we need to map them to objects. (DAO pattern requires this, JPA would do it for us)
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id,name,age FROM authors WHERE id  = (?) LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L));

    }

    @Test
    public void testThatFindManyGeneratesCorrectSql() {
        //as we get results FROM database, we need to map them to objects. (DAO pattern requires this, JPA would do it for us)
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT id,name,age FROM authors"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any()
        );

    }
}
