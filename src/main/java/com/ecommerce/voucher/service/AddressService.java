package com.ecommerce.voucher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.voucher.entity.Address;
import com.ecommerce.voucher.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	
	public Address getAddress(String addressId) {
		return addressRepository.findById(addressId).orElse(null);	
	}
	public Address createAddress(Address address) {
		return addressRepository.save(address);	
	}
	
	public List<Address> getCustomerAllAddress(String custId) {
		return addressRepository.findAllAddressByCustomerId(custId);
		
	}
	
	public Address getAddressByType(String custId,String type) {
		return addressRepository.findAddressByCustomerIdAndType(custId, type);
	}
	

}
