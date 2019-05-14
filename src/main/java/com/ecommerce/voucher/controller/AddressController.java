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

import com.ecommerce.voucher.entity.Address;
import com.ecommerce.voucher.entity.Product;
import com.ecommerce.voucher.service.AddressService;
import com.ecommerce.voucher.service.ProductService;

@RestController
@RequestMapping
public class AddressController {

	@Autowired
	AddressService addressService;


	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,path="/address")
	Address createAddress(@RequestBody Address address)  {
		return addressService.createAddress(address);

	}

	@GetMapping( path= "/address/{id}",produces =MediaType.APPLICATION_JSON_UTF8_VALUE) 
	Address getAddressById(@PathVariable("id") String addressId) { 

		return addressService.getAddress(addressId); 
	}

	@GetMapping( path= "/address/customer/{id}",produces =MediaType.APPLICATION_JSON_UTF8_VALUE) 
	List<Address> getAddressByCustId(@PathVariable("id") String custId) { 

		return addressService.getCustomerAllAddress(custId); 
	}
}
