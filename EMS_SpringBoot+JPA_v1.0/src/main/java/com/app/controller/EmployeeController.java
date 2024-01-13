package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Address;
import com.app.pojos.Employee;
import com.app.pojos.Project;
import com.app.service.AddressService;
import com.app.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	@Autowired
	private AddressService addrService;

	public EmployeeController() {
		System.out.println("In Contructor of Employee Controller");
	}

	@RequestMapping("/loadAllEmployeeForManager")
	public String loadTheEmployeesOnManagerDashboard(Model map, HttpSession session) {
		Employee emp = (Employee) session.getAttribute("manager");
		if (emp != null) {
			List<Employee> empList = empService.getAllEmployeeDetails();
			map.addAttribute("empList", empList);
			return "/manager/managerDashboard";
		}
		return "/mainLoginPage";
	}

	@RequestMapping(value = "/employeeDetails/{email}", method = RequestMethod.GET)
	public String projectDetails(@PathVariable String email, Model map, HttpSession session) {
		Employee manager = (Employee) session.getAttribute("manager");
		if (manager != null) {
			Employee empObj = empService.getEmployeeByEmail(email);
			Address addrObj = addrService.getAddressOfEmployee(empObj.getId());
			map.addAttribute("empDet", empObj);
			map.addAttribute("empAddr", addrObj);
			return "/manager/EmployeeInfo";
		}
		return "/mainLoginPage";
	}

	@RequestMapping("/projects/{email}")
	public String getProjectsOfEmployee(@PathVariable String email, Model map, HttpSession session) {
		System.out.println("In Project Details");
		Employee manager = (Employee) session.getAttribute("manager");
		if (manager != null) {
			Employee empObj = empService.getEmployeeByEmail(email);
			map.addAttribute("empDet", map.getAttribute("empDet"));
			List<Project> projects = new ArrayList<>(empObj.getEmployeeProjects());
			map.addAttribute("empProj", projects);
			map.addAttribute("empDetails", empObj);
			return "/manager/projectDetails";
		}
		return "/mainLoginPage";
	}
	
	@RequestMapping("/hire")
	public String hireEmployee()
	{
		return "/manager/hireEmployee";
	}
	
	@PostMapping("/hireEmployee")
	public String hireEmployeePost(@RequestParam String fname)
	{
		System.out.println(fname);
		System.out.println("In Hire");
		return "";
	}
	
	
	

}
