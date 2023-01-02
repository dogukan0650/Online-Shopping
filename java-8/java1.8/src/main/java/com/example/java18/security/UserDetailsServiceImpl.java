package com.example.java18.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.java18.dataAccess.repository.UserDao;
import com.example.java18.entities.User;
 
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserDao userDao;
     
    @Override
    @RequestMapping("/login")
    @CrossOrigin
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userDao.getByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
    }
 
}