package com.app.controller;

import java.net.http.HttpRequest;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private EmployeeService empService;

	public LoginController() {
		System.out.println("In Contructor of Login Controller");
	}
	
	//After entering the credentials, the next call of authenticating the user is done here, data is matched from the database
	//If the data is correct, then the the user is forwarded to managerDashboard, if he is the manager
	@PostMapping("/authenticateLogin")
	public String authenticateUserLogin(@RequestParam String email, @RequestParam String password,HttpSession session)
	{
//		empService.addEmployeeDetails(new Employee("Jayesh", "Murodiya", "jrmurodiya@gmail.com", "jayesh@123", LocalDate.now(), "FULL_TIME", 80000, "722787157086", "2001-01-24", true), "Full Stack Developer");
		System.out.println("In Authentication Phase of User!");
		session.setAttribute("manager", empService.authenticateLoginUserCreds(email, password));
		return "redirect:/employee/loadAllEmployeeForManager";
	}
	
	@RequestMapping("/logout")
	public String logoutHandler(HttpSession session)
	{
		session.invalidate();
		return "/mainLoginPage";
	}
	
}
