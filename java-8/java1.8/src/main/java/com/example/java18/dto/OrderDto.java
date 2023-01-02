package com.example.java18.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderDto {

	private int orderID;
	private int sellerID;
	private double totalPrice;
	private String address;
	private String orderStatus;
	private Date date;
	private boolean is_order_deleted;
	private List<ProductDto> product;

}
