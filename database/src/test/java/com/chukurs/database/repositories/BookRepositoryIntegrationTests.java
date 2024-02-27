package com.chukurs.database.repositories;

import com.chukurs.database.TestDataUtil;
import com.chukurs.database.domain.Author;
import com.chukurs.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
public class BookRepositoryIntegrationTests {
    private BookRepository underTest;

    //autowired helps with "constructor" injection, required Bean
    @Autowired
    public BookRepositoryIntegrationTests(BookRepository underTest) {
        this.underTest = underTest;
    }
    @Test
    public void testThatBookCanBeDeletedAndRecalledEmpty() {
        Book bookA = TestDataUtil.createTestBookA(TestDataUtil.createTestAuthorA());
        underTest.deleteById(bookA.getIsbn());

        Optional<Book> result = underTest.findById(bookA.getIsbn());
        assertThat(result.isEmpty());
    }
    @Test
    public void testThatBookCanBeUpdatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();

        Book book = TestDataUtil.createTestBookA(author);
        underTest.save(book);
        book.setTitle("UPDATED");
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);

    }
    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Book book = TestDataUtil.createTestBookA(TestDataUtil.createTestAuthorA());
        //book.setAuthorId(author.getId());
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);

    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
        Author authorA = TestDataUtil.createTestAuthorA();
        Author authorB = TestDataUtil.createTestAuthorB();
        Author authorC = TestDataUtil.createTestAuthorC();
        Author authorD = TestDataUtil.createTestAuthorD();

        Book bookA = TestDataUtil.createTestBookA(authorA);
        Book bookB = TestDataUtil.createTestBookB(authorB);
        Book bookC = TestDataUtil.createTestBookC(authorC);
        Book bookD = TestDataUtil.createTestBookD(authorD);

        underTest.save(bookA);
        underTest.save(bookB);
        underTest.save(bookC);
        underTest.save(bookD);

        Iterable<Book> result = underTest.findAll();
        assertThat(result).hasSize(4);
        assertThat(result).containsExactly(bookA, bookB, bookC, bookD);

    }


}
