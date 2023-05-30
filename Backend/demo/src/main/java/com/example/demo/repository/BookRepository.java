package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.entity.Book;


public interface BookRepository 
	extends JpaRepository<Book, Long>{

	@Query("SELECT b FROM Book b WHERE b.title = ?1")
	Optional<Book> findBookByTitle(String title);
	
	Book findByTitle(String title);

}
