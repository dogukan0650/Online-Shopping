package com.example.java18.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java18.business.service.TransactionServices;
import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.Transaction;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionsController {

	private TransactionServices transactionServices;
	
	@Autowired
	public TransactionsController(TransactionServices transactionServices) {
		super();
		this.transactionServices = transactionServices;
	}

	@GetMapping("/getall")
	public DataResult<List<Transaction>> getAll(){
		return this.transactionServices.getAll();
	}
	
	@PostMapping("/makeTransaction")
	public Result makeTransaction(Transaction transaction) {
		return this.transactionServices.makeTransaction(transaction);
	}
	
	@GetMapping("/getByTransactionID")
	public DataResult<Transaction> getByTransactionID(int transactionID){
		return this.transactionServices.getByTransactionID(transactionID);
	}
	
	@GetMapping("/getByUserID")
	public DataResult<List<Transaction>> getByUserID(int userID){
		return this.transactionServices.getByUserID(userID);
	}
	
	@GetMapping("/getByDate")
	public DataResult<List<Transaction>> getByDate(Date date){
		return this.transactionServices.getByDate(date);
	}
	
}
