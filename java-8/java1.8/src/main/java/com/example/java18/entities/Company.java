package com.example.java18.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int companyID;
	
	@Column(name = "CompanyName", nullable = false)
	private String companyName;
	
	@Column(name = "balance", columnDefinition = "double precision default 0")
	private double balance;
	
	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean is_deleted;
	
	@OneToMany(mappedBy = "company")
	private List<Product> product;
	
	@OneToMany(mappedBy = "company")
	private List<User> seller;
}
