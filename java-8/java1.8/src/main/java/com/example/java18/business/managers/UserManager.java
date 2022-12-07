package com.example.java18.business.managers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java18.business.service.UserServices;
import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.core.utilities.results.SuccessDataResult;
import com.example.java18.core.utilities.results.SuccessResult;
import com.example.java18.dataAccess.repository.UserDao;
import com.example.java18.entities.User;

@Service
public class UserManager implements UserServices {
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getActiveUsers(){
		return new SuccessDataResult<List<User>>(this.userDao.getActiveUsers());
	}
	
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Data successfully listed!");
	}

	@Override
	public Result create(User user) {
		this.userDao.save(user);
		return new SuccessResult("Data successfully listed!");
	}
	
	@Override
	public Result edit(User user) {
		this.userDao.save(user);
		return new SuccessResult("Data successfully edited!");
	}

	@Override
	public DataResult<User> getByUserID(int userID) {
		return new SuccessDataResult<User>
		(this.userDao.getByUserID(userID),"Data successfully listed!");
	}

	@Override
	public DataResult<List<User>> getByAccountType(String accontType) {
		return new SuccessDataResult<List<User>>(this.userDao.getByAccountType(accontType),"Data successfully listed!");
	}

	@Override
	public DataResult<List<User>> getByName(String name) {
		return new SuccessDataResult<List<User>>(this.userDao.getByName(name),"Data successfully listed!");
	}

	@Override
	public DataResult<List<User>> getBySurname(String surname) {
		return new SuccessDataResult<List<User>>(this.userDao.getBySurname(surname),"Data successfully listed!");
	}

	@Override
	public DataResult<User> getByUsername(String userName) {
		return new SuccessDataResult<User>(this.userDao.getByUsername(userName),"Data successfully listed!");
	}

	@Override
	public DataResult<List<User>> getByNameAndSurname(String name, String surname) {
		return new SuccessDataResult<List<User>>(this.userDao.getByNameAndSurname(name, surname), "Data successfully listed!") ;
	}
}