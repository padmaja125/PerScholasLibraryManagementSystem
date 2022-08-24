package com.project.perscholaslms.repository;


import com.project.perscholaslms.models.Book;
import com.project.perscholaslms.models.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuedBookRepository extends JpaRepository<IssuedBook, Long> {
	public Long countByBookAndReturned(Book book, Integer returned);
}
