package com.webpage.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webpage.thymeleaf.model.Employee;
import com.webpage.thymeleaf.service.employeeService;

@Controller
public class ThymeleadController {
	
	@Autowired
	employeeService employeeservice;
	
	@GetMapping("/upload")
	public String upload(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "upload";
	}
	
	@PostMapping("/uploademployee")
	public String uploadEmployee(@ModelAttribute("employee") Employee employee) {
		employeeservice.uploademployee(employee);
		return "uploadeddata";
	}
	
	@GetMapping("/allemployee")
	public String getallemployee(Model model) {
		model.addAttribute("all", employeeservice.getallemployee());
		return "allemployee";
	}
	
	@GetMapping("/getbyid")
	public String findemployee(@RequestParam(name="id", required = true) int id, Model model) {
		Boolean present = employeeservice.presentornot(id);
		model.addAttribute("presentornot", present);
		if(present==true)
		model.addAttribute("id",employeeservice.getemployeebyid(id));
		return "showsearch";
	}
	
}
