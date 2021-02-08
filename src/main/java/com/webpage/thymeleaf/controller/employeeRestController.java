package com.webpage.thymeleaf.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webpage.thymeleaf.model.Employee;
import com.webpage.thymeleaf.service.employeeService;

@RestController()
public class employeeRestController {
	
	@Autowired
	employeeService employeeservice;
	
    @PutMapping("/restupdate/{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee,@PathVariable Integer id) {
        try {

            Employee existUser = employeeservice.getemployeebyid(id);
            existUser.setAge(employee.getAge());
            existUser.setCompany(employee.getCompany());
            existUser.setEmployeeId(employee.getEmployeeId());
            existUser.setForename(employee.getForename());
            existUser.setPostcode(employee.getPostcode());
            existUser.setSurname(employee.getSurname());
            employeeservice.uploademployee(existUser);
            return ResponseEntity.status(HttpStatus.OK).body("Updated"+existUser);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found.");
        }
    }
    
    @DeleteMapping("/deleteid/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
    	try {
    		employeeservice.deleteUser(id);
    		return ResponseEntity.status(HttpStatus.OK).body("deleted");
    	}catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found.");
        }
    }
}
