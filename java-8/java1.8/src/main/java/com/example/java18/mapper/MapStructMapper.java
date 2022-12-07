package com.example.java18.mapper;

import org.mapstruct.Mapper;

import com.example.java18.dto.CategoryDto;
import com.example.java18.dto.CompanyDto;
import com.example.java18.dto.OrderDto;
import com.example.java18.dto.ProductDto;
import com.example.java18.dto.SubcategoryDto;
import com.example.java18.dto.TransactionDto;
import com.example.java18.dto.UserCreateDto;
import com.example.java18.dto.UserGetDto;

import com.example.java18.entities.Category;
import com.example.java18.entities.Company;
import com.example.java18.entities.Order;
import com.example.java18.entities.Product;
import com.example.java18.entities.Subcategory;
import com.example.java18.entities.Transaction;
import com.example.java18.entities.User;

@Mapper(componentModel = "spring")

public interface MapStructMapper {

	CategoryDto categoryToCategoryDto(Category category);
	
	Category categoryDtoToCategory(CategoryDto categoryDto);
	
	Company companyDtoToCompany(CompanyDto companyDto);

	CompanyDto companyToCompanyDto(Company company);

	OrderDto orderToOrderDto(Order order);

	ProductDto productToProductDto(Product product);
	
	Product productDtoToProduct(ProductDto productDto);

	SubcategoryDto subcategoryToSubcategoryDto(Subcategory subcategory);
	
	Subcategory subcategoryDtoToSubcategory(SubcategoryDto subcategoryDto);

	TransactionDto transactionToTransactionDto(Transaction transaction);

	UserGetDto userToUserGetDto(User user);
	
	User userDtoToUser(UserGetDto userGetDto);

	User userToUserCreateDto(UserCreateDto userCreateDto);

}
