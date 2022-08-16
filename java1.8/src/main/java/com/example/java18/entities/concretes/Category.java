package com.example.java18.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {

	@Id
	@Column(name = "ID")
	private int categoryID;

	@Column(name = "categoryName")
	private String categoryName;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
}
