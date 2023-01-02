package com.example.java18.dto;

import java.util.Date;
import lombok.Data;

@Data
public class TransactionDto {

	private int transactionID;
	private double amount;
	private Date date;
	private boolean is_transaction_deleted;

}
