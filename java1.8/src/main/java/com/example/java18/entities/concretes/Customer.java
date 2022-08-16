package com.example.java18.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","orders"})

@Table(name="customer")
public class Customer{
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="ID", nullable = false)
		private int customerID;
		
		@Column(name="accountType", nullable = false)
		private String accountType="customer";
		
		@Column(name="name", nullable = false)
		private String name="";
		
		@Column(name="surname")
		private String surname="";
		
		@Column(name="age")
		@ColumnDefault("18")
		private int age;
		
		@Column(name="gender")
		@ColumnDefault("male")
		private String gender;
		
		@Column(name="username",nullable = false )
		private String username="";
		
		@Column(name="password")
		private String password="";
		
		@Column(name="address", nullable = false)
		private String address;

		@Column(name="balance", nullable = false)
		private double balance=0;
		
		@Column(name="is_deleted", nullable = false, columnDefinition = " boolean default 'false' ")
		private boolean is_user_deleted=false;
		
		
		@OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "ID")
	    private User user;
		

		@OneToMany(mappedBy = "customer")
		private List<Order> order;
		
}
