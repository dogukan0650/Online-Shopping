package com.example.java18.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserGetDto {
	
    @JsonProperty("userID")
	private int userID;
    
    @JsonProperty("role")
	private String role;
    
    @JsonProperty("name")
	private String name;
    
    @JsonProperty("surname")
	private String surname;
    
    @JsonProperty("age")
	private int age;
    
    @JsonProperty("username")
	private String username;
    
    @JsonProperty("gender")
	private String gender;
    
    @JsonProperty("balance")
	private double balance;
    
    @JsonProperty("address")
	private String address;
    
    @JsonProperty("_user_deleted")
	private boolean is_user_deleted;
    
    private CompanyDto company;
    
    @JsonProperty("order")
    private List<OrderDto> order;

	
	
}
