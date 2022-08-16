package com.example.java18.entities.concretes;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="transactions")
public class Transaction {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private int transactionID;
	
	
	@Column(name="amount", nullable = false)
	private double amount;
	
	@Column(name = "description")
	private String transactionDescription="";
	
	@Generated(value = { "date" })
	@Column(name="transactionDate", nullable = false)
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date date;
	
	@Column(name="isDeleted")
	private boolean is_transaction_deleted; 
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customerID")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sellerID")
	private Seller seller;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orderID")
	private Order order;
	
	
}
