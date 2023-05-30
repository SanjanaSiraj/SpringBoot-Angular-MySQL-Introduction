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

import com.example.demo.entity.Bookshop;
import com.example.demo.service.BookshopService;


@RestController
@RequestMapping(path = "api/bookshops")
public class BookshopController {
	
	@Autowired
    private BookshopService bookshopService;
	
	
	//create a new book
		@PostMapping
		public void registerNewBookshop(@RequestBody Bookshop bookshop) {
			bookshopService.addNewBookshop(bookshop);
		}
		
		//retrieve all books
		@GetMapping
		public List<Bookshop> getBookshops(){
			return bookshopService.getBookshops();
		}
		
		//retrieve a book by Id
		@GetMapping(path = "{shopId}")
		public Bookshop getBookshopById(@PathVariable("shopId") long shopId){
			return bookshopService.getBookshopById(shopId);
		}
		
		//retrieve a book by Title
		@GetMapping(path = "/name/{shopName}")
		public Bookshop getBookshopByTitle(@PathVariable("shopName") String shopName){
			return bookshopService.getBookshopByTitle(shopName);
		}
		
		//update a book by Id
		@PutMapping(path = "{shopId}")
		public Bookshop updateBookshop(@RequestBody Bookshop bookshop){
	        return bookshopService.updateBookshop(bookshop);
	    }
		
		//delete a book by Id
		@DeleteMapping(path = "{shopId}")
		public void deleteBookshop(@PathVariable("shopId") long shopId) {
			bookshopService.deleteBookshop(shopId);
		}
		
		//delete all books
		@DeleteMapping
		public void deleteAllBookshops() {
			bookshopService.deleteAllBookshops();
		}
    
    
}
