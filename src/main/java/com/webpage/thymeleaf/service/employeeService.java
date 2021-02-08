package com.webpage.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webpage.thymeleaf.model.Employee;
import com.webpage.thymeleaf.repository.thymeleafRepository;


@Service
public class employeeService {
	
	@Autowired
	thymeleafRepository thymeleafrepository;
	
	public Employee uploademployee(Employee employee) {
		return thymeleafrepository.save(employee);
	}
	
	public  Iterable<Employee> getallemployee() {
		return thymeleafrepository.findAll();
	}
	
	public Employee getemployeebyid(int id) {
		return thymeleafrepository.findById(id).get();
	}
	
	public Boolean presentornot(int id) {
		return thymeleafrepository.existsById(id);
	}
	
    public void deleteUser(Integer id) {
    	thymeleafrepository.deleteById(id);
    }
}
