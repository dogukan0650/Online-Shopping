package com.example.java18.dto;

import lombok.Data;

@Data
public class ProductDto {

	private int productID;
	private String productName;
	private double price;
	private int unitStock;
	private String description;
	private boolean is_published;
	private boolean is_deleted;
	private CategoryDto category;
	
}
