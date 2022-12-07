package com.example.java18.business.service;

import java.util.List;
import java.util.Date;

import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.Order;

public interface OrderServices {
	
	Result makeOrder(Order order);
	
	DataResult<Order> getByOrderID(int orderID);
	
	DataResult<List<Order>>  getAll();
	
	DataResult<List<Order>> getOrderByUserID(int customerID);
	
	DataResult<List<Order>> getBySellerID(int sellerID);
	
	DataResult<List<Order>> getByCustomerIDAndSellerID(int customerID, int sellerID);

	//DataResult<List<Order>> getByDate(Date date);
}
