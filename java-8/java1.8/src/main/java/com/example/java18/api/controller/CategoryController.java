package com.example.java18.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.java18.business.service.CategoryServices;
import com.example.java18.business.service.SubcategoryService;
import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.Category;
import com.example.java18.entities.Subcategory;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {
	private CategoryServices categoryServices;
	private SubcategoryService subcategoryServices;
	 
	/*---*/
	
	@Autowired
	public CategoryController(CategoryServices categoryServices, SubcategoryService subcategoryService) {
		this.categoryServices = categoryServices;
		this.subcategoryServices = subcategoryService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Category>> getAll(){
		return this.categoryServices.getAll();
	}
	
	@GetMapping("/getallSub")
	public DataResult<List<Subcategory>> getAllSubCat(){
		return this.subcategoryServices.getAll();
	}
	
	@GetMapping("/findDistinctCategory")
	public DataResult<List<Category>> findDistinctCategory(){
		return this.categoryServices.findDistinctCategory();
	} 
	
	@PostMapping("/add")
	public Result add(@RequestBody Category category) {
		return this.categoryServices.add(category);
	}
	
	@GetMapping("/getByCategoryID")
	public DataResult<Category> getByCategoryID(@RequestParam int categoryID){
		return this.categoryServices.getByCategoryID(categoryID);
	}
	
	@GetMapping("/getByCategoryName")
	public DataResult<List<Category>> getByCategoryName(@RequestParam String categoryName){
		return this.categoryServices.getByCategoryName(categoryName);
	}
	
	@GetMapping("/getSubCategoryByCategoryName")
	public DataResult<List<Subcategory>> getSubCategoryByCategoryName(@RequestParam String categoryName){
		return this.subcategoryServices.getByCategoryName(categoryName);
	}
	
	@GetMapping("/getSubCategoryByCategoryNameAndSubCategoryName")
	public DataResult<List<Category>> getSubCategoryByCategoryNameAndSubCategoryName(@RequestParam("categoryName") String categoryName,@RequestParam("subCategoryName")  String subCategoryName){
		return this.categoryServices.getSubCategoryByCategoryNameAndSubCategoryName(categoryName, subCategoryName);
	}
	
}
