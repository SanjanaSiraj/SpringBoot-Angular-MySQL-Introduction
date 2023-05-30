package com.example.demo.entity;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="bookId")

public class Book {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long bookId;
	 @ManyToOne
	 //@JsonBackReference
	 private Bookshop bookShop;
	 @ManyToOne
	 //@JsonBackReference
	 private Author author;
	 private String title;
	 private double price;
	 private int  year_of_publish;
	 private String genre;
	 private String publisher;
}
