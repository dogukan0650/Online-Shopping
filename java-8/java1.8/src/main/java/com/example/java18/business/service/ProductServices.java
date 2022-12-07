package com.example.java18.business.service;

import java.util.List;

import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.Category;
import com.example.java18.entities.Product;

public interface ProductServices {

	DataResult<Product> getById(int id);

	DataResult<List<Product>> getAll();

	Result add(Product product);

	DataResult<Product> getByProductName(String productName);
	
	DataResult<List<Product>> getActiveProduct();

	DataResult<List<Product>> getByCategoryIn(Category categories);
	
	//DataResult<List<Product>> getBySubCategoryIn(List<String> category);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);
																							 
	DataResult<List<Product>> getByNameAndCategory(String productName, String categoryName/* 0, @Param bunu da kullan. */);

}