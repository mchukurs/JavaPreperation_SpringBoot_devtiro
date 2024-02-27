//package com.chukurs.database.repositories;
//
//import com.chukurs.database.TestDataUtil;
//import com.chukurs.database.domain.Author;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class AuthorDaoImplIntegrationTest {
//
//    private AuthorDaoImpl underTest;
//
//    //autowired helps with "constructor" injection, required Bean
//    @Autowired
//    public AuthorDaoImplIntegrationTest(AuthorDaoImpl underTest) {
//        this.underTest = underTest;
//    }
//
//    @Test
//    public void testThatAuthorCanBeDeletedAndRecalledEmpty() {
//        Author authorA = TestDataUtil.createTestAuthorA();
//        underTest.delete(authorA.getId());
//
//        Optional<Author> result = underTest.findOne(authorA.getId());
//        // assertThat(result).isEqualTo(authorA);
//        assertThat(result.isEmpty());
//    }
//
//    @Test
//    public void testThatAuthorCanBeUpdatedAndRecalled() {
//        Author authorA = TestDataUtil.createTestAuthorA();
//        underTest.update(authorA.getId(), authorA);
//
//        Optional<Author> result = underTest.findOne(authorA.getId());
//        // assertThat(result).isEqualTo(authorA);
//        assertThat(result.isPresent());
//    }
//
//    @Test
//    public void testThatAuthorCanBeCreatedAndRecalled() {
//        Author authorA = TestDataUtil.createTestAuthorA();
//        underTest.create(authorA);
//
//        Optional<Author> result = underTest.findOne(authorA.getId());
//        assertThat(result.get()).isEqualTo(authorA);
//        assertThat(result.isPresent());
//
//
//    }
//
//    @Test
//    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
//        Author authorA = TestDataUtil.createTestAuthorA();
//        Author authorB = TestDataUtil.createTestAuthorB();
//        Author authorC = TestDataUtil.createTestAuthorC();
//        Author authorD = TestDataUtil.createTestAuthorD();
//
//        underTest.create(authorA);
//        underTest.create(authorB);
//        underTest.create(authorC);
//        underTest.create(authorD);
//
//
//        List<Author> result = underTest.find();
//        assertThat(result).hasSize(4);
//
//
//        assertThat(result).containsExactly(authorA, authorB, authorC, authorD);
//
//
//    }
//
//
//}
