package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;




@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;


	


	public Book getBookById(long bookId) {
		// TODO Auto-generated method stub
		return bookRepository.findById(bookId).get();
	}



	public Book getBookByTitle(String title) {
		// TODO Auto-generated method stub
		 return bookRepository.findByTitle(title);
	}



	public void deleteAllBooks() {
		// TODO Auto-generated method stub
		bookRepository.deleteAll();
	}



	public void addNewBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}



	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}



	public void deleteBook(long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}



	public Book updateBook(Book book){
        Book prev=bookRepository.findById(book.getBookId()).orElse(null);
        prev.setBookShop(book.getBookShop());
        prev.setAuthor(book.getAuthor());
        prev.setTitle(book.getTitle());
        prev.setPrice(book.getPrice());
        prev.setYear_of_publish(book.getYear_of_publish());
        prev.setGenre(book.getGenre());
        prev.setPublisher(book.getPublisher());
        return bookRepository.save(prev);
    }
	

}
