package com.example.java18.dataAccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.java18.entities.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
	
	Order getByOrderID(int orderID);
	
	@Query("from Order where userID = ?1")
	List<Order> getOrderByUserID(int userID);
	
	//@Query("from Order where sellerID =: sellerID")
	List<Order> getBySellerID(int sellerID);
	
	@Query("from Order where userID = ?1 and sellerID = ?2")
	List<Order> getByCustomerIDAndSellerID(int customerID, int sellerID);
	
	/* Date e göre çekme nasıl yapabilirsin bak
	 * Örnek olarak şu tarihten sonrakiler veya öncekiler veya o gün içerisindekiler*/

}
