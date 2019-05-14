package com.ecommerce.voucher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.voucher.entity.Customer;
import com.ecommerce.voucher.service.CustomerService;

@RestController
@RequestMapping
public class CustomerController {
	@Autowired
	CustomerService customerService;

	//TODO pagination required, velocity check which ganapathi told
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,path = "/customers")
	List<Customer> getCustomers(){
		return customerService.getCustomers();
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,path = "/customers/{id}")
	Customer getCustomerById(@PathVariable("id") String customerId) {
		return customerService.getCustomerById(customerId);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,path = "/customers")
	Customer createCustomer(@RequestBody Customer customer) throws Exception {
		return customerService.createCustomer(customer);
	}


}