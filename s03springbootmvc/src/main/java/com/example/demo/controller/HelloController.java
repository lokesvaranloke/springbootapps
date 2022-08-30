package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World";
	}
	
	
	//http://localhost:8080/greet?name=Max --> to pass parameter in url
	@RequestMapping("/greet")
	@ResponseBody
	public String greet(@RequestParam String name) {
		return "Hello "+name;
	}
}
