package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;

@Service
public class CustomerService 
{
	@Autowired
	CustomerDao dao;
	
	public String add(Customer customer)
	{
		dao.save(customer);
		return "Success";
	}

	public List<Customer> getAllCustomers() 
	{
		return dao.findAll();
	}


	public String remove(Integer id) 
	{
		dao.deleteById(id);
		return "Success";
	}

	public String update(Customer newcustomer, Integer id) 
	{
		dao.findById(id).map(customer ->{
			customer.setName(newcustomer.getName());
			customer.setAddress(newcustomer.getAddress());
			customer.setMeterSerialNumber(newcustomer.getMeterSerialNumber());
			return dao.save(customer);
			
		});
		return "Success";
	}
	
	
}
