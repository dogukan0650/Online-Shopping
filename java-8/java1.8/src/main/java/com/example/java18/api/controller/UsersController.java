package com.example.java18.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.java18.business.service.UserServices;
import com.example.java18.core.utilities.results.DataResult;
import com.example.java18.core.utilities.results.Result;
import com.example.java18.entities.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {
	private UserServices userService;

	@Autowired
	public UsersController(UserServices userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/getall")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}
	
	@GetMapping("/getActiveUsers")
	public DataResult<List<User>> getActiveUsers(){
		return this.userService.getActiveUsers();
	}

	@PostMapping("/create")
	public Result create(@RequestBody User user) {
		return this.userService.create(user);
	}
	
	@PostMapping("/edit")
	public Result edit(User user) {
		return this.userService.edit(user);
	}
	@GetMapping("/getByAccountType") 
	public DataResult<List<User>> getByAccountType(String accontType){
		return this.userService.getByAccountType(accontType);
	} 

	@GetMapping("/getByName")
	public DataResult<List<User>> getByName(@RequestParam String name){
		return this.userService.getByName(name);
	}

	@GetMapping("/getBySurname")
	public DataResult<List<User>> getBySurname(@RequestParam String surname){
		return this.userService.getBySurname(surname);
	}
	
	@GetMapping("/getByNameAndSurname")
	public DataResult<List<User>> getByNameAndSurname(@RequestParam String name, @RequestParam String surame){
		return this.userService.getByNameAndSurname(name, surame);
	}

	@GetMapping("/getByUsername")
	public DataResult<User> getByUsername(@RequestParam String userName){
		return this.userService.getByUsername(userName);
	}

}
