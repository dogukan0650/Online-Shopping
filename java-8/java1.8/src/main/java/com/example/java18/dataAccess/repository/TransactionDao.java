package com.example.java18.dataAccess.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.java18.entities.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {

	Transaction getByTransactionID(int transactionID);

	@Query("from Transaction where userID = ?1")
	List<Transaction> getByUserID(int userID);

	@Query("from Transaction where date = ?1")
	List<Transaction> getByDate(Date date);
}
