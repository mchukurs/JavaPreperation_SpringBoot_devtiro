package com.chukurs.database;

import com.chukurs.database.domain.Author;
import com.chukurs.database.domain.Book;

public final class TestDataUtil {
    private TestDataUtil() {

    }


    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Abigail Rose A")
                .age(81)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Abigail Rose B")
                .age(82)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Abigail Rose C")
                .age(83)
                .build();
    }

    public static Author createTestAuthorD() {
        return Author.builder()
                .id(4L)
                .name("Abigail Rose D")
                .age(84)
                .build();
    }
    //
    //
    //

    public static Book createTestBookA(final Author author) {
        return Book.builder()
                .isbn("1234-5678-9098-1")
                .title("The shadow in the attic A")
                .author(author)
                .build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder()
                .isbn("1234-5678-9098-2")
                .title("The shadow in the attic B")
                .author(author)
                .build();
    }

    public static Book createTestBookC(final Author author) {
        return Book.builder()
                .isbn("1234-5678-9098-3")
                .title("The shadow in the attic C")
                .author(author)
                .build();
    }

    public static Book createTestBookD(final Author author) {
        return Book.builder()
                .isbn("1234-5678-9098-4")
                .title("The shadow in the attic D")
                .author(author)
                .build();
    }
}
