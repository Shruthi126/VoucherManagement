package com.ecommerce.voucher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.voucher.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,String>{
	
	public Customer findCustomerByMsisdn(String msisdn);
	
	public Customer findCustomerByEmail(String email);
	
	public Customer findCustomerByEmailAndMsisdn(String email, String msisdn);
	
	public Customer findCustomerByEmailOrMsisdn(String email, String msisdn);
}
