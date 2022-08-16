package com.example.java18.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.concretes.Product;

public interface ProductServices {

	DataResult<List<Product>> getAll();

	Result add(Product product);

	DataResult<Product> getByProductName(String productName);

	DataResult<Product> getByProductNameAndCategory(String productName, int categoryID);

	DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryID);

	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);
																							 
	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryID /* 0, @Param bunu da kullan. */);

}