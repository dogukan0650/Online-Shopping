package com.example.java18.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.java18.business.abstracts.UserServices;
import com.example.java18.dataAccess.abstracts.UserDao;
import com.example.java18.entities.concretes.User;

@Service
public class UserManager implements UserServices {
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAll(){
		return this.userDao.findAll();
	}
}