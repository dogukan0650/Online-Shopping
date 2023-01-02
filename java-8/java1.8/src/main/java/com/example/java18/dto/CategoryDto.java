package com.example.java18.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CategoryDto {
	
	
    @JsonProperty("categoryID")
	private int categoryID;
    
    @JsonProperty("categoryName")
	private String categoryName;
    
    @JsonProperty("SubcategoryDto")
	private List<SubcategoryDto> subcategory;
    
    @JsonProperty("product")
    private List<ProductDto> product;

}
