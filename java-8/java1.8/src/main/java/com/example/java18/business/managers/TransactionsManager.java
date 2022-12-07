package com.example.java18.business.managers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java18.business.service.TransactionServices;
import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.core.utilities.results.SuccessDataResult;
import com.example.java18.core.utilities.results.SuccessResult;
import com.example.java18.dataAccess.repository.TransactionDao;
import com.example.java18.entities.Transaction;

@Service
public class TransactionsManager implements TransactionServices {
	private TransactionDao transactionDao;

	@Autowired
	public TransactionsManager(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

	@Override
	public DataResult<List<Transaction>> getAll() {
		return new SuccessDataResult<List<Transaction>>(this.transactionDao.findAll(), "Data successfully listed!");
	}

	@Override
	public Result makeTransaction(Transaction transaction) {
		this.transactionDao.save(transaction);
		return new SuccessResult("Data successfully created!");
	}

	@Override 
	public DataResult<Transaction> getByTransactionID(int transactionID) {
		return new SuccessDataResult<Transaction>(this.transactionDao.getByTransactionID(transactionID),"Data successfully listed!");
	}

	@Override
	public DataResult<List<Transaction>> getByUserID(int userID) {
		return new SuccessDataResult<List<Transaction>>(this.transactionDao.getByUserID(userID),"Data successfully listed!");
	}

	@Override
	public DataResult<List<Transaction>> getByDate(Date date){
		return new SuccessDataResult<List<Transaction>>(this.transactionDao.getByDate(date), "Data successfully listed!");
	}
}
