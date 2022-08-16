package com.example.java18.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.java18.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
