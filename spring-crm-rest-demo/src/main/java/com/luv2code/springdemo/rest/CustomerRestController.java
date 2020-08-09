package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// auto wire the customer service
	@Autowired
	private CustomerService customerService;

	// add mapping for get customer
	@GetMapping("customers")
	public List<Customer> getCustomer() {

		return customerService.getCustomers();

	}
}