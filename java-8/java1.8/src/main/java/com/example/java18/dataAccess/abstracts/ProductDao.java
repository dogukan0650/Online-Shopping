package com.example.java18.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.java18.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {	
	
	
	
	// constraint bulunanları maplemek gerekebilir aksi takdirde hata alırsın
	// örnek: getByProductNameAndSeller_sellerID(...) şeklinde. getByProductNameAndSeller şeklinde
	// yazarsan object olarak alır hata alırsın.
	
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory(String productName, int categoryID);
	
	List<Product> getByProductNameOrCategory(String productName, int categoryID);
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("from Product where productName=:productName and category.categoryID=:categoryID" /*,nativeQuery=true*//*false de olacak*/)
	List<Product> getByNameAndCategory(String productName,int categoryID /*0, @Param bunu da kullan.*/);
	
}




















