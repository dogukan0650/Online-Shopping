package com.example.java18.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public  class User implements Serializable  {
	
	private static final long serialVersionUID = 736680233685514283L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", nullable = false)
	private int userID;
	
	@Column(name = "role", nullable = false)
	private String role;
	
	@Column(name="name", nullable = false)
	private String name="";
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "age", columnDefinition =  " integer default 0")
	private int age;

	@Column(name = "gender", columnDefinition =  " varchar default 'male'")
	private String gender;
	
	@Column(name="username",nullable = false )
	private String username="";
	
	@Column(name="password", nullable = false)
	private String password="";
	
	@Column(name="balance", nullable = false)
	private double balance=0;
	
	@Column(name="address", columnDefinition =  " varchar default '-'")
	private String address;
	
	@Column(name="is_deleted", nullable = false, columnDefinition =  " boolean default false")
	private boolean is_user_deleted=false;
	
	
	
	
	@OneToMany(mappedBy = "customer")
	private List<Order> order;
	
	@ManyToOne
	@JoinColumn(name = "companyID")
	private Company company;
	
	
	/* connections between user and usertypes */
	/*
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Customer customer;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Admin admin;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Seller seller;
	*/

	
	/*-----connections-----*/
	
	/*
	@OneToMany(targetEntity = Product.class ,mappedBy = "sellerID" )
	private List<Product> products; // bence burası oldu*/
	
	/* burada bir logical sıkıntı var connectionlar düzgün ayarlanmıyor */
	/*@OneToMany(targetEntity = Order.class ,mappedBy = "customerID")
	private List<Order> order;*/
	/*
	@OneToMany(targetEntity = Order.class ,mappedBy = "sellerID")
	private List<Order> ordersTaken;  */
}