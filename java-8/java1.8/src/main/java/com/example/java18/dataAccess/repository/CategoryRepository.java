package com.example.java18.dataAccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.java18.entities.Category;
import com.example.java18.entities.Subcategory;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
		
	@Query("from Category where categoryID = ?1")
	Category getByCategoryID(int categoryID);

	@Query("from Category where categoryName = ?1")
	List<Category> getByCategoryName(String categoryName);
	
	@Query(value = "select DISTINCT category_name from Category ", nativeQuery = true)
	List<Category> findDistinctCategory();
	
	@Query("from Subcategory where categoryName = ?1 AND subCategoryName = ?2")
	List<Category> getSubCategoryByCategoryNameAndSubCategoryName(String categoryName, String subCategoryName);
	
}
