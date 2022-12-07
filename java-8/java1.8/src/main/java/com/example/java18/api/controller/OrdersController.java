package com.example.java18.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.java18.business.service.OrderServices;
import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.Order;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrdersController {

	private OrderServices orderService;

	@Autowired
	public OrdersController(OrderServices orderService) {
		super();
		this.orderService = orderService;
	}

	@GetMapping("/getall")
	public DataResult<List<Order>> getall() {
		return this.orderService.getAll();
	}

	@PostMapping("/makeorder")
	public Result makeOrder(@RequestBody Order order) {
		return this.orderService.makeOrder(order);
	}

	@GetMapping("/getbyuserid")
	public DataResult<List<Order>> getOrderByUserID(@RequestParam("customer.ID")int customerID ) {
		return this.orderService.getOrderByUserID(customerID);
	}

	public DataResult<List<Order>> getBySellerID(@RequestParam("sellerID")int sellerID) {
		return this.orderService.getBySellerID(sellerID);
	}

	public DataResult<List<Order>> getByCustomerIDAndSellerID(@RequestParam("customer.ID") int customerID  ,@RequestParam("sellerID") int sellerID ) {
		return this.orderService.getByCustomerIDAndSellerID(customerID, sellerID);
	}

}
