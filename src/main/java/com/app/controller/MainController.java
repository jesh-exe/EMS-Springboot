package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	public MainController() {
		System.out.println("In Constructor of Main Controller");
	}
	
	//First Call after opening the website is handled here, and forwarded to the mainLoginPage.jsp 
	@GetMapping("/")
	public String handleLoginPage()
	{
		System.out.println("Handling the Login Page call");
		return "/mainLoginPage";
	}
	
}
