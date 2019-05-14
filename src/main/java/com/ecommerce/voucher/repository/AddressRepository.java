package com.ecommerce.voucher.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.voucher.entity.Address;

public interface AddressRepository extends CrudRepository<Address,String> {

	List<Address> findAllAddressByCustomerId(String customerId);
	
	Address findAddressByCustomerIdAndType(String customerId, String type);
}
