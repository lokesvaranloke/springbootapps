package com.example.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.authentication.entity.User;
import com.example.authentication.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/login")
	public String showUserpage() {
		return "index";
	}
	
	@RequestMapping(value="/adduser", method= {RequestMethod.POST})
	public String create(@ModelAttribute ("user") User user,ModelMap model) {
		service.saveUser(user);
		return "successful";
	}
	
	@GetMapping("/viewusers")
	public String getUsers(@ModelAttribute ("user") User user,ModelMap model) {
		Iterable<User> users = service.GetAllUsers();
		model.addAttribute("user", users);
		return "listusers";
	}

}
