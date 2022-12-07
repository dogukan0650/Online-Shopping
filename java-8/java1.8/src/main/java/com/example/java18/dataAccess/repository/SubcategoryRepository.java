package com.example.java18.dataAccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.java18.entities.Category;
import com.example.java18.entities.Subcategory;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer>{
	
	
	@Query("from Subcategory where subcategoryID = ?1")
	Subcategory getBySubcategoryID(int subcategoryID);

	@Query("from Subcategory where subcategoryName = ?1")
	List<Subcategory> getBySubcategoryName(String subcategoryName);
	
	
	@Query("from Subcategory where category IN ( select categoryID from Category where categoryName = ?1)")
	List<Subcategory> getByCategoryName(String categoryName);
	
	
	@Query("from Subcategory where subcategoryName = ?1")
	List<Subcategory> getByCategoryID(int categoryID);
	
	@Query("from Subcategory where categoryName = ?1")
	List<Category> getCategoryBySubcategoryName(String subcategoryName);
	
	
}
