package com.ecommerce.voucher.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document @Data
public class Address {
	
	@Id
	private String addressId;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String pinCode;
	
	private AddressType type;
	
	private String customerId;
	
	public enum AddressType{
		Home,Office,Other;
	}
}


