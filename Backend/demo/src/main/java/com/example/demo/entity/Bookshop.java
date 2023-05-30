package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="shopId")

public class Bookshop {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long shopId;
	 private String shopName;
	 private String location;
	 private String email;
	 private String contactNo;
	 @OneToMany(mappedBy = "bookShop")
	 //@JsonManagedReference
	 private List<Book> books;
}
