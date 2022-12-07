package com.example.java18.api.controller;

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

import com.example.java18.business.service.ProductServices;
import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.Category;
import com.example.java18.entities.Product;


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
	
	@GetMapping("/getById")
	public DataResult<Product> getById(@RequestParam int id){
		return this.productService.getById(id);
	}
	
	@GetMapping("/getActiveProduct")
	public DataResult<List<Product>> getActiveProduct(){
		return this.productService.getActiveProduct();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByCategoryIDIn")
	public DataResult<List<Product>> getByCategoryIn( @RequestParam("subCategoryName") Category category){
		return this.productService.getByCategoryIn(category);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam("productName") String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam("productName") String productName){
		return this.productService.getByProductNameStartsWith(productName);
	}
	
	@GetMapping("/getByNameAndsubCategoryName")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryName") String categoryName){
		return this.productService.getByNameAndCategory(productName, categoryName);
	}
	
}
