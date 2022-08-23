package com.project.perscholaslms;

import com.project.perscholaslms.models.Book;
import com.project.perscholaslms.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepo;


    /* Executed this first */
    @Test
    public void testCreateBook() {
        Book book = new Book();
        book.setAuthors("Prem");
        book.setIsbn("isbn");
        book.setPublisher("sbn");
        book.setTitle("ThomasTrain");



        Book savedBook = bookRepo.save(book);

        assertThat(savedBook.getAuthors()).isEqualTo("Prem");
        assertThat(savedBook.getTitle()).isEqualTo("ThomasTrain");
        assertThat(savedBook.getIsbn()).isEqualTo("isbn");
        assertThat(savedBook.getPublisher()).isEqualTo("sbn");

    }

}