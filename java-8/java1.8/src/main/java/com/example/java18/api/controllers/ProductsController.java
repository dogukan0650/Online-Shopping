package com.example.java18.api.controllers;

import java.util.List;
// utility libraries
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//classes for data manipulation
import com.example.java18.business.abstracts.ProductServices;
import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.concretes.Product;


@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
	
	private ProductServices productService;
	
	@Autowired
	public ProductsController(ProductServices productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	
	
	@GetMapping("/getByProductNameAndCategoryID")
	public DataResult<Product> getByProductNameAndCategoryID(@RequestParam("productName") String productName, @RequestParam("categoryID") int categoryID){
		return this.productService.getByProductNameAndCategoryID(productName, categoryID);
	}

	
	@GetMapping("/getByCategoryIDIn")
	public DataResult<List<Product>> getByCategoryIDIn( @RequestParam("categoryID") List<Integer> categoryID){
		return this.productService.getByCategoryIDIn(categoryID);
	}
	
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam("productName") String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	
	@GetMapping("/getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam("productName") String productName){
		return this.productService.getByProductNameStartsWith(productName);
	}
	
	
	@GetMapping("/getByNameAndCategory")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryID") int categoryID){
		return this.productService.getByNameAndCategory(productName, categoryID);
	}
	
}
