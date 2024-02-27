package com.chukurs.database.dao.impl;

import com.chukurs.database.dao.AuthorDao;
import com.chukurs.database.domain.Author;
import com.chukurs.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTest {
    private AuthorDao authorDao;
    private BookDaoImpl underTest;

    //autowired helps with "constructor" injection, required Bean
    @Autowired
    public BookDaoImplIntegrationTest(BookDaoImpl underTest, AuthorDao authorDao) {
        this.underTest = underTest;
        this.authorDao = authorDao;
    }
    @Test
    public void testThatBookCanBeDeletedAndRecalledEmpty() {
        Book bookA = TestDataUtil.createTestBookA();
        underTest.delete(bookA.getIsbn());

        Optional<Book> result = underTest.findOne(bookA.getIsbn());
        assertThat(result.isEmpty());
    }
    @Test
    public void testThatBookCanBeUpdatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);
        Book book = TestDataUtil.createTestBookA();
        book.setTitle("UPDATED");
        book.setAuthorId(author.getId());
        underTest.create(book);
        underTest.update(book.getIsbn(),book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);

    }
    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);
        Book book = TestDataUtil.createTestBookA();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);

    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
        Author authorA = TestDataUtil.createTestAuthorA();
        Author authorB = TestDataUtil.createTestAuthorB();
        Author authorC = TestDataUtil.createTestAuthorC();
        Author authorD = TestDataUtil.createTestAuthorD();

        authorDao.create(authorA);
        authorDao.create(authorB);
        authorDao.create(authorC);
        authorDao.create(authorD);

        Book bookA = TestDataUtil.createTestBookA();
        Book bookB = TestDataUtil.createTestBookB();
        Book bookC = TestDataUtil.createTestBookC();
        Book bookD = TestDataUtil.createTestBookD();

        bookA.setAuthorId(authorA.getId());
        bookB.setAuthorId(authorB.getId());
        bookC.setAuthorId(authorC.getId());
        bookD.setAuthorId(authorD.getId());

        underTest.create(bookA);
        underTest.create(bookB);
        underTest.create(bookC);
        underTest.create(bookD);

        List<Book> result = underTest.find();
        assertThat(result).hasSize(4);
        assertThat(result).containsExactly(bookA, bookB, bookC, bookD);

    }


}
