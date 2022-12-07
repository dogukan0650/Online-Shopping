package com.example.java18.business.service;

import java.util.List;

import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.User;

public interface UserServices {
	
	 DataResult<List<User>> getActiveUsers();
	 DataResult< List<User>> getAll();
	 Result create(User user);
	 Result edit(User user);
	 DataResult<User> getByUserID(int userID);
	 DataResult<List<User>> getByAccountType(String accontType);
	 DataResult<List<User>> getByName(String name);
	 DataResult<List<User>> getBySurname(String surname);
	 DataResult<List<User>> getByNameAndSurname(String name, String surame);
	 DataResult<User> getByUsername(String userName);
	 
	 
}
