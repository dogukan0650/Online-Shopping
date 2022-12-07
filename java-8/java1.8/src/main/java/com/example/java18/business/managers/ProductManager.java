package com.example.java18.business.managers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java18.business.service.ProductServices;
import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.core.utilities.results.SuccessDataResult;
import com.example.java18.core.utilities.results.SuccessResult;
import com.example.java18.dataAccess.repository.ProductDao;
import com.example.java18.entities.Category;
import com.example.java18.entities.Product;

@Service
public class ProductManager implements ProductServices{
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public DataResult<Product> getById(int id){
		return new SuccessDataResult<Product>(this.productDao.getById(id));
	}
	
	@Override
	public DataResult<List<Product>> getAll() {	
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data successfully listed!");
	}
	
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Product successfuly added.");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName), "Data successfully listed!");
	}
	
	@Override
	public DataResult<List<Product>> getActiveProduct(){
		return new SuccessDataResult<List<Product>>(this.productDao.getActiveProduct(), "Data successfully listed!");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(Category category) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategoryIn(category), "Data successfully listed!");
	}
	/*
	@Override
	public DataResult<List<Product>> getBySubCategoryIn(List<String> category) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getBySubCategoryIn(category), "Data successfully listed!");
	}
*/
	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName), "Data successfully listed!");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName), "Data successfully listed!");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, String categoryName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName, categoryName), "Data successfully listed!");
	}
	
}