package com.example.java18.business.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java18.business.service.CategoryServices;
import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.core.utilities.results.SuccessDataResult;
import com.example.java18.core.utilities.results.SuccessResult;
import com.example.java18.dataAccess.repository.CategoryRepository;
import com.example.java18.entities.Category;
import com.example.java18.entities.Subcategory;

@Service
public class CategoryManager implements CategoryServices{

	private CategoryRepository categoryDao;
	
	@Autowired
	public CategoryManager(CategoryRepository categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Override
	public DataResult<List<Category>> getAll() {
		return new SuccessDataResult<List<Category>>(this.categoryDao.findAll(), "Data successfully listed!");
	}
	

	@Override
	public Result add(Category category) {
		this.categoryDao.save(category);
		return new SuccessResult("Category successfuly added.");
	}

	@Override
	public DataResult<Category> getByCategoryID(int categoryID) {
		return new SuccessDataResult<Category>(this.categoryDao.getByCategoryID(categoryID), "Data successfully listed!");
	}
	
	@Override
	public DataResult<List<Category>> getByCategoryName(String categoryName) {
		return new SuccessDataResult<List<Category>>(this.categoryDao.getByCategoryName(categoryName), "Data successfully listed!");
	}
	
	@Override
	public DataResult<List<Category>> findDistinctCategory(){
		return new SuccessDataResult<List<Category>>(this.categoryDao.findDistinctCategory());
	}
	

	@Override
	public DataResult<List<Category>> getSubCategoryByCategoryNameAndSubCategoryName(String categoryName,
			String subCategoryName) {
		return new SuccessDataResult<List<Category>>(this.categoryDao.getSubCategoryByCategoryNameAndSubCategoryName(categoryName, subCategoryName), "Data successfully listed!");
	}

}
