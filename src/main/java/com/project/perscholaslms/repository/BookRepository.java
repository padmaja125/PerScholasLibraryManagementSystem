package com.project.perscholaslms.repository;


import com.project.perscholaslms.models.Book;
import com.project.perscholaslms.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	@Query("select b from Book b where b.tag = :tag")
	public Book findByTag(@Param("tag") String tag);
	public List<Book> findByCategory(Category category);
	public List<Book> findByCategoryAndStatus(Category category, Integer status);
	public Long countByStatus(Integer status);
}
