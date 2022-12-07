package com.example.java18.dataAccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.java18.entities.Category;
import com.example.java18.entities.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {	
	
	
	
	// constraint bulunanları maplemek gerekebilir aksi takdirde hata alırsın
	// örnek: getByProductNameAndSeller_sellerID(...) şeklinde. getByProductNameAndSeller şeklinde
	// yazarsan object olarak alır hata alırsın.
	
	Product getById(int id);
	
	Product getByProductName(String productName);
	
	@Query("from Product where is_deleted = 'false' ")
	List<Product> getActiveProduct();
	
	@Query("from Product where category.categoryName=: categories")
	List<Product> getByCategoryIn(Category categories);
	
	//@Query("from Product where category.subcategory.subCategoryName=: categories")
	//List<Product> getBySubCategoryIn(List<String> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	 
	@Query("from Product where productName =: productName AND category.categoryName =: category" /*,nativeQuery=true*//*false de olacak*/)
	List<Product> getByNameAndCategory(String productName, String category /*0, @Param bunu da kullan.*/);
	
}




















