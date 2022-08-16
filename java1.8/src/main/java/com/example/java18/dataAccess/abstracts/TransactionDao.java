package com.example.java18.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.java18.entities.concretes.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Integer>{

}
