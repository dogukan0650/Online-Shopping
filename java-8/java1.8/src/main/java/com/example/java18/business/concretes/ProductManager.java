package com.example.java18.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.java18.business.abstracts.ProductServices;
import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.core.utilities.results.SuccessDataResult;
import com.example.java18.core.utilities.results.SuccessResult;
import com.example.java18.dataAccess.abstracts.ProductDao;
import com.example.java18.entities.concretes.Product;

@Service
public class ProductManager implements ProductServices{
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		this.productDao = productDao;
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
	public DataResult<Product> getByProductNameAndCategoryID(String productName, int categoryID) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategoryID(productName, categoryID), "Data successfully listed!");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryID(String productName, int categoryID) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategoryID(productName, categoryID), "Data successfully listed!");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIDIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategoryIDIn(categories), "Data successfully listed!");
	}

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
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryID) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName, categoryID), "Data successfully listed!");
	}
	
}