package com.example.java18.business.abstracts;

import java.util.List;
import com.example.java18.entities.concretes.Transaction;

public interface TransactionServices {	
	public List<Transaction> getAll();
}
