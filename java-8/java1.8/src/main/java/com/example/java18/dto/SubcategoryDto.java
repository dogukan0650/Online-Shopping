package com.example.java18.dto;

import lombok.Data;

@Data
public class SubcategoryDto {

	private int subCategoryID;
	private String subCategoryName;
	private CategoryDto categoryDto;
	
}
