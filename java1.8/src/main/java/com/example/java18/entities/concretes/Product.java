
package com.example.java18.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","seller"})
@Table(name="products")
public class Product {
	////////////////variables////////////////////////////////////////////////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", nullable = false)
	private int productID;
	
	/*
	@Column(name="categoryID", nullable = false)
	private int categoryID=0;
	*/
	@Column(name="productName", nullable = false)
	private String productName="";
	
	@Column(name="price", nullable = false)
	private double price=0.0;
	
	@Column(name="unitStock",nullable = false )
	private int unitStock=0;
	
	@Column(name="description")
	private String description="";
	
	@Column(name="is_published", nullable = false)
	private boolean is_published=false;
	
	@Column(name="is_deleted", nullable = false )
	private boolean is_deleted=false;
	
	 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sellerID")		/* One seller has many products. Relation set by sellerID*/
	private Seller seller;
										/* burada bir sıkıntı var error veriyor*/
	
	
	
	@ManyToOne
		/* One order has many products. Relation set by productID*/
	private Order order;
	
	
	@ManyToOne()
	@JoinColumn(name= "categoryID")
	private Category category;
	
}
