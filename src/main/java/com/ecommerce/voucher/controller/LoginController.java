package com.ecommerce.voucher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.voucher.entity.Customer;
import com.ecommerce.voucher.repository.CustomerRepository;
import com.ecommerce.voucher.util.SecureUtility;

public class LoginController {

	@Autowired
	CustomerRepository customerRepository;

	@RequestMapping(path = "/", method = RequestMethod.POST, produces="application/json",consumes = "application/json")
	public Customer customerLogin(@RequestBody Customer customer) {
		try{
			Customer cust = customerRepository.findCustomerByEmailOrMsisdn(customer.getUsername(),customer.getUsername());
			if(null!=cust) {
				char[] enterPassword=SecureUtility.hashPassword(customer.getPassword(), cust.getSalt());
				if(enterPassword.length==cust.getPassword().length) {
					for(int i=0;i<enterPassword.length;i++) {
						if(enterPassword[i]!=cust.getPassword()[i]) {
							throw new Exception("Password/Username is wrong");
						}
					}
				}else {
					throw new Exception("Password/Username is wrong");
				}
			}else {
				throw new Exception("Password/Username is wrong");
			}

		}catch (Exception e){
			System.out.println(e);
		}
		return customer;

	}



}
