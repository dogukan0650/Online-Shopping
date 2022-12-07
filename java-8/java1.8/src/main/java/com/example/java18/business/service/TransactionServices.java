package com.example.java18.business.service;

import java.util.Date;
import java.util.List;

import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.Transaction;

public interface TransactionServices {	
	
	DataResult<List<Transaction>> getAll();
	
	Result makeTransaction(Transaction transaction);
	
	DataResult<Transaction> getByTransactionID(int transactionID);
	
	DataResult<List<Transaction>> getByUserID(int userID);
	
	DataResult<List<Transaction>> getByDate(Date date);
}
