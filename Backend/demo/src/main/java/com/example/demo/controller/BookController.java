package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping(path = "api/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//create a new book
	@PostMapping
	public void registerNewBook(@RequestBody Book book) {
		bookService.addNewBook(book);
	}
	
	//retrieve all books
	@GetMapping
	public List<Book> getBooks(){
		return bookService.getBooks();
	}
	
	//retrieve a book by Id
	@GetMapping(path = "{bookId}")
	public Book getBookById(@PathVariable("bookId") long bookId){
		return bookService.getBookById(bookId);
	}
	
	//retrieve a book by Title
	@GetMapping(path = "/title/{title}")
	public Book getBookByTitle(@PathVariable("title") String title){
		return bookService.getBookByTitle(title);
	}
	
	//update a book by Id
	@PutMapping(path = "{bookId}")
	public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }
	
	//delete a book by Id
	@DeleteMapping(path = "{bookId}")
	public void deleteBook(@PathVariable("bookId") long bookId) {
		bookService.deleteBook(bookId);
	}
	
	//delete all books
	@DeleteMapping
	public void deleteAllBooks() {
		bookService.deleteAllBooks();
	}
	
}
