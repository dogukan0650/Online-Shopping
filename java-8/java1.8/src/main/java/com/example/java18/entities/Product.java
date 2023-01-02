
package com.example.java18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "company" })
@Table(name = "products")
public class Product {
	//////////////// variables////////////////////////////////////////////////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int productID;

	@Column(name = "productName", nullable = false)
	private String productName = "";

	@Column(name = "price", nullable = false)
	private double price = 0.0;

	@Column(name = "unitStock", nullable = false)
	private int unitStock = 0;

	@Column(name = "description")
	private String description = "";

	@Column(name = "is_published", nullable = false, columnDefinition = " boolean default false")
	private boolean is_published = false;

	@Column(name = "is_deleted", nullable = false, columnDefinition = " boolean default false")
	private boolean is_deleted = false;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyName") /* One seller has many products. Relation set by sellerID */
	private Company company;
	/* burada bir sıkıntı var error veriyor */

	@JsonIgnore
	@ManyToOne
	/* One order has many products. Relation set by productID */
	private Order order;

	@ManyToOne
	private Category category;

}
