package com.webpage.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;

import com.webpage.thymeleaf.model.Employee;


public interface thymeleafRepository extends CrudRepository<Employee, Integer>{

}
