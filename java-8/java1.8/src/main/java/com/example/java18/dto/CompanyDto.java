package com.example.java18.dto;

import java.util.List;


import lombok.Data;

@Data
public class CompanyDto {

	private int companyID;
	private String companyName;
	private double balance;
	private boolean is_deleted;
	private List<ProductDto> product;
	private List<UserGetDto> seller;

}
