package com.example.java18.mapper;

import java.util.ArrayList;
import java.util.List;

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

public class MapStructMapperImpl implements MapStructMapper {

	@Override
	public CategoryDto categoryToCategoryDto(Category category) {
		if (category == null) {
			return null;

		}

		CategoryDto categoryDto = new CategoryDto();

		categoryDto.setCategoryID(category.getCategoryID());
		categoryDto.setCategoryName(category.getCategoryName());
		categoryDto.setProduct(productListToProductDtoList(category.getProduct()));
		categoryDto.setSubcategory(subcategoryListTosubcategoryDtoList(category.getSubcategory()));

		return categoryDto;
	}

	@Override
	public Category categoryDtoToCategory(CategoryDto categoryDto) {
		if (categoryDto == null) {
			return null;
		}

		Category category = new Category();

		category.setCategoryID(categoryDto.getCategoryID());
		category.setCategoryName(categoryDto.getCategoryName());
		category.setProduct(productDtoListToProductList(categoryDto.getProduct()));
	//	category.setSubcategory((categoryDto.getSubcategory()));

		return category;
	}
	
	@Override
	public ProductDto productToProductDto(Product product) {
		if (product == null) {
			return null;
		}

		ProductDto productDto = new ProductDto();

		productDto.set_deleted(product.is_deleted());
		productDto.set_published(product.is_published());
		productDto.setDescription(product.getDescription());
		productDto.setPrice(product.getPrice());
		productDto.setProductID(product.getProductID());
		productDto.setProductName(product.getProductName());
		productDto.setUnitStock(product.getUnitStock());

		return productDto;
	}

	@Override
	public Product productDtoToProduct(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}

		Product product = new Product();

		product.set_deleted(productDto.is_deleted());
		product.set_published(productDto.is_published());
	//	product.setCategory(productDto.getCategory());

		return product;
	}

	@Override
	public CompanyDto companyToCompanyDto(Company company) {

		if (company == null) {
			return null;
		}

		CompanyDto companyDto = new CompanyDto();

		companyDto.setCompanyID(company.getCompanyID());
		companyDto.setCompanyName(company.getCompanyName());
		companyDto.setBalance(company.getBalance());
		companyDto.set_deleted(company.is_deleted());
		companyDto.setProduct(productListToProductDtoList(company.getProduct()));
		companyDto.setSeller(userListToUserDtoList(company.getSeller()));

		return companyDto;
	}

	@Override
	public Company companyDtoToCompany(CompanyDto companyDto) {
		if (companyDto == null) {
			return null;
		}

		Company company = new Company();
		company.set_deleted(companyDto.is_deleted());
		company.setBalance(companyDto.getBalance());
		company.setCompanyID(companyDto.getCompanyID());
		company.setCompanyName(companyDto.getCompanyName());
		company.setProduct(productDtoListToProductList(companyDto.getProduct()));
		company.setSeller(userDtoListToUserList(companyDto.getSeller()));

		return company;
	}
	
	@Override
	public OrderDto orderToOrderDto(Order order) {
		if (order == null) {
			return null;
		}

		OrderDto orderDto = new OrderDto();

		orderDto.set_order_deleted(order.is_order_deleted());
		orderDto.setAddress(order.getAddress());
		orderDto.setDate(order.getDate());
		orderDto.setOrderID(order.getOrderID());
		orderDto.setOrderStatus(order.getOrderStatus());
		orderDto.setSellerID(order.getSellerID());
		orderDto.setTotalPrice(order.getTotalPrice());
		orderDto.setProduct(productListToProductDtoList(order.getProduct()));

		return orderDto;
	}

	@Override
	public SubcategoryDto subcategoryToSubcategoryDto(Subcategory subcategory) {
		if (subcategory == null) {
			return null;
		}
		SubcategoryDto subcategoryDto = new SubcategoryDto();

		subcategoryDto.setSubCategoryID(subcategory.getSubCategoryID());
		subcategoryDto.setSubCategoryName(subcategory.getSubCategoryName());

		return subcategoryDto;
	}

	@Override
	public Subcategory subcategoryDtoToSubcategory(SubcategoryDto subcategoryDto) {
		if (subcategoryDto == null) {
			return null;
		}
		
		Subcategory subcategory = new Subcategory();
		
	//	subcategory.setCategory(subcategoryDto.getCategoryDto());
		subcategory.setSubCategoryID(subcategoryDto.getSubCategoryID());
		subcategory.setSubCategoryName(subcategoryDto.getSubCategoryName());
		
		return subcategory;
		
	}
	
	@Override
	public TransactionDto transactionToTransactionDto(Transaction transaction) {
		if (transaction == null) {
			return null;
		}

		TransactionDto transactionDto = new TransactionDto();

		transactionDto.set_transaction_deleted(transaction.is_transaction_deleted());
		transactionDto.setAmount(transaction.getAmount());
		transactionDto.setDate(transaction.getDate());
		transactionDto.setTransactionID(transaction.getTransactionID());

		return transactionDto;

	}

	@Override
	public UserGetDto userToUserGetDto(User user) {
		if (user == null) {
			return null;
		}
		UserGetDto userGetDto = new UserGetDto();

		userGetDto.set_user_deleted(user.is_user_deleted());
		userGetDto.setAddress(user.getAddress());
		userGetDto.setAge(user.getAge());
		userGetDto.setBalance(user.getBalance());
		userGetDto.setGender(user.getGender());
		;
		userGetDto.setName(user.getName());
		userGetDto.setOrder(orderListToOrderDtoList(user.getOrder()));
		userGetDto.setRole(user.getRole());
		userGetDto.setSurname(user.getSurname());
		userGetDto.setUserID(user.getUserID());
		userGetDto.setUsername(user.getUsername());

		return userGetDto;

	}

	@Override
	public User userToUserCreateDto(UserCreateDto userCreateDto) {
		if (userCreateDto == null) {
			return null;
		}

		User user = new User();

		user.set_user_deleted(userCreateDto.is_deleted());
		user.setAddress(userCreateDto.getAddress());
		user.setAge(userCreateDto.getAge());
		user.setBalance(userCreateDto.getBalance());
	//	user.setCompany(companyListToCompanyDtoList(userCreateDto.getCompany()));
		user.setGender(userCreateDto.getGender());
		user.setName(userCreateDto.getName());
	//	user.setOrder(userCreateDto.getOrder());
		user.setPassword(userCreateDto.getPassword());
		user.setRole(userCreateDto.getRole());
		user.setSurname(userCreateDto.getSurname());
		user.setUserID(userCreateDto.getUserID());
		user.setUsername(userCreateDto.getUsername());

		return user;
	}

	@Override
	public User userDtoToUser(UserGetDto userGetDto) {
		if (userGetDto == null) {
			return null;
		}
		User user = new User();

		user.set_user_deleted(userGetDto.is_user_deleted());
		user.setAddress(userGetDto.getAddress());
		user.setAge(userGetDto.getAge());
		user.setBalance(userGetDto.getBalance());
	//	user.setCompany(companyToCompanyDto(userGetDto.getCompany()));
		user.setGender(userGetDto.getGender());
		user.setName(userGetDto.getName());
	//	user.setOrder(userGetDto.getOrder());
		user.setRole(userGetDto.getRole());
		user.setSurname(userGetDto.getSurname());
		user.setUserID(userGetDto.getUserID());
		user.setUsername(userGetDto.getUsername());

		return user;

	}

	protected List<SubcategoryDto> subcategoryListTosubcategoryDtoList(List<Subcategory> subcategoryList) {
		if (subcategoryList == null) {
			return null;
		}

		List<SubcategoryDto> subcategoryDtoList = new ArrayList<SubcategoryDto>(subcategoryList.size());

		for (Subcategory subcategory : subcategoryList) {
			subcategoryDtoList.add(subcategoryToSubcategoryDto(subcategory));
		}

		return subcategoryDtoList;
	}

	protected List<Subcategory> subcategoryDtoListTosubcategoryList(List<SubcategoryDto> subcategoryDtoList) {
		if (subcategoryDtoList == null) {
			return null;
		}

		List<Subcategory> subcategoryList = new ArrayList<Subcategory>(subcategoryDtoList.size());

		for (Subcategory subcategory : subcategoryList) {
	//		subcategoryList.add(subcategoryDtoToSubcategory(subcategory));
		}

		return subcategoryList;
	}

	protected List<ProductDto> productListToProductDtoList(List<Product> listProduct) {

		if (listProduct == null) {
			return null;
		}

		List<ProductDto> listProductDto = new ArrayList<ProductDto>(listProduct.size());

		for (Product product : listProduct) {
			listProductDto.add(productToProductDto(product));
		}

		return listProductDto;
	}

	protected List<Product> productDtoListToProductList(List<ProductDto> productDtoList) {

		if (productDtoList == null) {
			return null;
		}

		List<Product> productList = new ArrayList<Product>(productDtoList.size());

		for (ProductDto productDto : productDtoList) {
			productList.add(productDtoToProduct(productDto));
		}

		return productList;
	}

	protected List<OrderDto> orderListToOrderDtoList(List<Order> orderList) {

		if (orderList == null) {
			return null;
		}

		List<OrderDto> orderListDto = new ArrayList<OrderDto>(orderList.size());

		for (Order order : orderList) {
			orderListDto.add(orderToOrderDto(order));
		}

		return orderListDto;
	}

	protected List<CompanyDto> companyListToCompanyDtoList(List<Company> companyList) {

		if (companyList == null) {
			return null;
		}

		List<CompanyDto> companyDtoList = new ArrayList<CompanyDto>(companyList.size());

		for (Company company : companyList) {
			companyDtoList.add(companyToCompanyDto(company));
		}
		return companyDtoList;
	}

	protected List<Company> companyDtoListToCompanyList(List<CompanyDto> companyDtoList) {

		if (companyDtoList == null) {
			return null;
		}

		List<Company> companyList = new ArrayList<Company>(companyDtoList.size());

		for (CompanyDto companyDto : companyDtoList) {
			companyList.add(companyDtoToCompany(companyDto));
		}
		return companyList;
	}

	protected List<UserGetDto> userListToUserDtoList(List<User> userList) {
		if (userList == null) {
			return null;
		}

		List<UserGetDto> userDtoList = new ArrayList<UserGetDto>(userList.size());

		for (User user : userList) {
			userDtoList.add(userToUserGetDto(user));
		}

		return userDtoList;
	}

	protected List<User> userDtoListToUserList(List<UserGetDto> userDtoList) {

		if (userDtoList == null) {
			return null;
		}

		List<User> userList = new ArrayList<User>();

		for (UserGetDto userDto : userDtoList) {
			userList.add(userDtoToUser(userDto));
		}

		return userList;
	}

	
}
