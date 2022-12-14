package com.example.java18.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int orderID;

	@Column(name = "sellerID", nullable = false) /// array olması gerekli
	private int sellerID;
	
	@Column(name = "price", nullable = false)
	private double totalPrice;

	@Column(name = "address", nullable = false)
	private String address = "";

	@Column(name = "status", nullable = false)
	private String orderStatus = "";

	@Column(name = "orderDate", nullable = false)
	//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date date;

	@Column(name = "is_deleted", nullable = false)
	private boolean is_order_deleted = false; 

	//// relation types.

	@ManyToOne
	@JoinColumn(name = "customerID")
	private User customer; /* one customer has many orders. Relation set by customerID */


	@OneToMany(mappedBy = "order")
	private List<Product> product;
 
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Transaction transaction;
 
	// sellerID ler product sellerID den gelecek o yüzden ona göre bir ayarlama yap
	// ve sellerID ler list olmalı (1den fazla satıcıdan order olabilir.)
	
	public void setTotalPrice(List<Product> products) {
		for (Product prod : products) {
			totalPrice = totalPrice + prod.getPrice();
		}
	}

	public double getTotalPrice() {
		return totalPrice;
	}
}
