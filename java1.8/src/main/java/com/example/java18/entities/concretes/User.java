package com.example.java18.entities.concretes;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userID", nullable = false)
	private int userID;
	
	@Column(name="accountType", nullable = false)
	private String accountType="";
	
	@Column(name="name", nullable = false)
	private String name="";
	
	@Column(name="username",nullable = false )
	private String username="";
	
	@Column(name="password")
	private String password="";
	
	@Column(name="is_deleted", nullable = false)
	@org.hibernate.annotations.ColumnDefault("false")
	private boolean is_user_deleted=false;
	
	
	/* connections between user and usertypes */
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Customer customer;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Admin admin;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Seller seller;
	

	
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