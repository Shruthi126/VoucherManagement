package com.ecommerce.voucher.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.voucher.entity.Customer;
import com.ecommerce.voucher.exception.CustomerException;
import com.ecommerce.voucher.repository.CustomerRepository;
import com.ecommerce.voucher.util.SecureUtility;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getCustomers(){
		List<Customer> customerList= new ArrayList<Customer>();
		 customerRepository.findAll().forEach(customerList::add);
		
		 return customerList;
	}
	
	public Customer createCustomer(Customer customer) throws Exception {
		String email=customer.getEmail();
		String msisdn=customer.getMsisdn();
		
		if(null!=customerRepository.findCustomerByEmail(email) || null!=customerRepository.findCustomerByMsisdn(msisdn))
			throw new CustomerException("Your email or/and mobile number is registered with us. Please login");	
			
			if(null==customer.getUsername() || customer.getUsername().isEmpty())
				customer.setUsername(customer.getEmail());
			
			try {
				//TODO decrypt password before this. Encryption logic tbd
				customer.setSalt(SecureUtility.getSalt());
				customer.setPassword(SecureUtility.hashPassword(customer.getPassword(), customer.getSalt()));
			} catch (NoSuchAlgorithmException e) {
				throw new Exception("Internal server error");
			}
			return customerRepository.save(customer);
			
			
		
	}
	
	public Customer getCustomerById(String customerId) {
		return customerRepository.findById(customerId).orElse(null);
		
	}
	
	public List<Customer> getMultpileCustomerById(List<String> customerId) {
			List<Customer> customers= new ArrayList<Customer>();
		  customerRepository.findAllById(customerId).forEach(a->customers.add(a));
		  return customers;
	}
	

}
