package com.example.java18.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.java18.entities.concretes.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
	
	Order getByOrderID(int orderID);
	
	List<Order> getByCustomerID(int customerID);
	
	List<Order> getBySellerID(int sellerID);
	
	@Query("from Order where customerID=:customerID and sellerID=:sellerID")
	List<Order> getByCustomerIDAndSellerID(int customerID, int sellerID);
	
	/* Date e göre çekme nasıl yapabilirsin bak
	 * Örnek olarak şu tarihten sonrakiler veya öncekiler veya o gün içerisindekiler*/

}
