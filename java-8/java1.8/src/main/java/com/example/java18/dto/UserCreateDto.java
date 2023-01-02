package com.example.java18.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserCreateDto {
	private int userID;
	private String role;
	private String name;
	private String surname;
	private int age;
	private String username;
	private String password;
	private String gender;
	private double balance;
	private String address;
	private boolean is_deleted;
	private CompanyDto company;
	private List<String> order;

}
