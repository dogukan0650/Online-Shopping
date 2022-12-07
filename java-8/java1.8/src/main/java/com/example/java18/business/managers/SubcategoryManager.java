package com.example.java18.business.managers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.java18.business.service.SubcategoryService;
import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.Category;
import com.example.java18.entities.Subcategory;
import com.example.java18.core.utilities.results.SuccessDataResult;
import com.example.java18.core.utilities.results.SuccessResult;
import com.example.java18.dataAccess.repository.SubcategoryRepository;

@Service
public class SubcategoryManager implements SubcategoryService {

	private SubcategoryRepository subcategoryRepository;
	
	public SubcategoryManager(SubcategoryRepository subcategoryRepository) {
		this.subcategoryRepository = subcategoryRepository;
	}
	
	@Override
	public DataResult<List<Subcategory>> getAll(){
		return new SuccessDataResult<List<Subcategory>>(this.subcategoryRepository.findAll());
	}
	
	@Override
	public DataResult<Subcategory> getBySubcategoryID(int subcategoryID) {
		return new SuccessDataResult<Subcategory>(this.subcategoryRepository.getBySubcategoryID(subcategoryID));
	}

	@Override
	public Result add(Subcategory subcategory) {
		this.subcategoryRepository.save(subcategory);
		return new SuccessResult("Subcategory successfully added!");
	}

	@Override
	public DataResult<List<Subcategory>> getBySubcategoryName(String subcategoryName) {
		return new SuccessDataResult<List<Subcategory>>(this.subcategoryRepository.getBySubcategoryName(subcategoryName));
	}

	@Override
	public DataResult<List<Subcategory>> getByCategoryName(String categoryName) {
		return new SuccessDataResult<List<Subcategory>>(this.subcategoryRepository.getByCategoryName(categoryName));
	}

	@Override
	public DataResult<List<Subcategory>> getByCategoryID(int categoryID) {
		return new SuccessDataResult<List<Subcategory>>(this.subcategoryRepository.getByCategoryID(categoryID));
	}

	@Override
	public DataResult<List<Category>> getCategoryBySubcategoryName(String subcategoryName) {
		return new SuccessDataResult<List<Category>>(this.subcategoryRepository.getCategoryBySubcategoryName(subcategoryName));
	}

}
