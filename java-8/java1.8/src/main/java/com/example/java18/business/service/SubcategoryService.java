package com.example.java18.business.service;

import java.util.List;

import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.Category;
import com.example.java18.entities.Subcategory;

public interface SubcategoryService {

	DataResult<List<Subcategory>> getAll();

	Result add(Subcategory subcategory);

	DataResult<Subcategory> getBySubcategoryID(int subcategoryID);

	DataResult<List<Subcategory>> getBySubcategoryName(String subcategoryName);

	DataResult<List<Subcategory>> getByCategoryName(String subcategoryName);

	DataResult<List<Subcategory>> getByCategoryID(int categoryID);

	DataResult<List<Category>> getCategoryBySubcategoryName(String subcategoryName);

}
