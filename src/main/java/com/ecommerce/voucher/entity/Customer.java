package com.ecommerce.voucher.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

import lombok.Data;

@Document @Data
public class Customer extends ResourceSupport {
	
	@Id
	private String customerId;
	
	private String name;
	
	private String email;
	
	private String msisdn;
	
	@Transient
	private char[] password;
	
	@Transient
	private String salt;
	
	private String username;
	
}
