package com.example.java18.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java18.business.abstracts.TransactionServices;
import com.example.java18.dataAccess.abstracts.TransactionDao;
import com.example.java18.entities.concretes.Transaction;


@Service
public class TransactionsManager implements TransactionServices{
	private TransactionDao transactionDao;
	
	@Autowired
	public TransactionsManager(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}
	
	@Override
	public List<Transaction> getAll(){
		return this.transactionDao.findAll();
	}
	
}
