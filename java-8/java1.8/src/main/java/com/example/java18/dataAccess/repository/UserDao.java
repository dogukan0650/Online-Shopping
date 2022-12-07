package com.example.java18.dataAccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.java18.entities.User;

@Repository
//FIXME İsimlendirme ne olmalı? DAO, DTO nedir?
public interface UserDao extends JpaRepository<User, Integer> {

	@Query("from User where is_deleted = 'false'")
	List<User> getActiveUsers();
	
	User getByUserID(int userID);

	@Query("from User where accontType = ?1")
	List<User> getByAccountType(String accontType);

	@Query("from User where name = ?1")
	List<User> getByName(String name);

	@Query("from User where surname = ?1")
	List<User> getBySurname(String surname);
	
	@Query("from User where name = ?1 and surname = ?2")
	List<User> getByNameAndSurname(String name, String surname);
	 
	@Query("from User where username = ?1")
	User getByUsername(String userName);
}
