package com.example.java18.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", nullable = false)
	private int adminID;
	
	@Column(name="accountType", nullable = false)
	private String accountType="customer";
	
	@Column(name="name", nullable = false)
	private String name="";
	
	@Column(name="username",nullable = false )
	private String username="";
	
	@Column(name="password")
	private String password="";
	
	@Column(name="address", nullable = false)
	private String address;

	@Column(name="balance", nullable = false)
	private double balance=0;
	
	@Column(name="is_deleted", nullable = false)
	@ColumnDefault("false")
	private boolean is_user_deleted;

	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID")
    private User user;
	
}
