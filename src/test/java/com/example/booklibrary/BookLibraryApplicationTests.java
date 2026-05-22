package com.example.booklibrary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookLibraryApplicationTests {

    @Autowired
    private BookRepository repo;

    @Test
    void contextLoads() {}

    @Test
    void seedDataIsPresent() {
        assertThat(repo.findAll()).isNotEmpty();
    }

    @Test
    void findByAuthor() {
        assertThat(repo.findByAuthorIgnoreCase("Frank Herbert")).hasSize(1);
    }
}
