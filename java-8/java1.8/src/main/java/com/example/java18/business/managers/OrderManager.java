package com.example.java18.business.managers;

import com.example.java18.business.service.OrderServices;
import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.core.utilities.results.SuccessDataResult;
import com.example.java18.core.utilities.results.SuccessResult;
import com.example.java18.dataAccess.repository.OrderDao;
import com.example.java18.entities.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManager implements OrderServices{
	private OrderDao orderDao;
	
	@Autowired
	public OrderManager(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	@Override
	public DataResult<Order> getByOrderID(int orderID){
		return new SuccessDataResult<Order>(this.orderDao.getByOrderID(orderID));
	}
	
	@Override
	public DataResult<List<Order>>  getAll(){
		return new SuccessDataResult<List<Order>>(this.orderDao.findAll(), "Data successfully listed!");
	}

	@Override
	public Result makeOrder(Order order) {
		this.orderDao.save(order);
		return new SuccessResult("Order successfully made!");
	}

	@Override
	public DataResult<List<Order>> getOrderByUserID(int customerID) {
		return new SuccessDataResult<List<Order>>(this.orderDao.getOrderByUserID(customerID), "Data successfully listed!");
	}

	@Override
	public DataResult<List<Order>> getBySellerID(int sellerID) {
		return new SuccessDataResult<List<Order>>(this.orderDao.getBySellerID(sellerID), "Data successfully listed!");
	}

	@Override
	public DataResult<List<Order>> getByCustomerIDAndSellerID(int customerID, int sellerID) {
		return new SuccessDataResult<List<Order>>(this.orderDao.getByCustomerIDAndSellerID(customerID, sellerID), "Data successfully listed!");
	}

	
}
