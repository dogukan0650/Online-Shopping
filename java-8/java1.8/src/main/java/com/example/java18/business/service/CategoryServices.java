package com.example.java18.business.service;

import java.util.List;

import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.Category;
import com.example.java18.entities.Subcategory;

public interface CategoryServices {

	DataResult<List<Category>> getAll();
		
	Result add(Category category);
	
	DataResult<Category> getByCategoryID(int categoryID);
	
	DataResult<List<Category>> getByCategoryName(String categoryName);
	
	DataResult<List<Category>> findDistinctCategory();

	DataResult<List<Category>> getSubCategoryByCategoryNameAndSubCategoryName(String categoryName, String subCategoryName);
}
