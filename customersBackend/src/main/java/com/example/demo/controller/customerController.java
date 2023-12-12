package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@CrossOrigin("http://localhost:3000")
public class customerController 
{
	
	@Autowired
	CustomerService service;
	
	@PostMapping("add")
	public String add(@RequestBody Customer customer)
	{
		return service.add(customer);
	}
	
	@GetMapping("getAll")
	public List<Customer> getAllCustomers()
	{
		return service.getAllCustomers();
	}
	
	
	@DeleteMapping("delete/{id}")
	public String remove(@PathVariable Integer id)
	{
		return service.remove(id);
	}
	
	@PutMapping("update/{id}")
	public String updateCustomer(@RequestBody Customer customer, @PathVariable Integer id)
	{
		return service.update(customer, id);
	}
}
