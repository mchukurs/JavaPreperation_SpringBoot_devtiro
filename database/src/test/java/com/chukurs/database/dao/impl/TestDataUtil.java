package com.chukurs.database.dao.impl;

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

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("1234-5678-9098-1")
                .title("The shadow in the attic A")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder()
                .isbn("1234-5678-9098-2")
                .title("The shadow in the attic B")
                .authorId(2L)
                .build();
    }

    public static Book createTestBookC() {
        return Book.builder()
                .isbn("1234-5678-9098-3")
                .title("The shadow in the attic C")
                .authorId(3L)
                .build();
    }

    public static Book createTestBookD() {
        return Book.builder()
                .isbn("1234-5678-9098-4")
                .title("The shadow in the attic D")
                .authorId(4L)
                .build();
    }
}
