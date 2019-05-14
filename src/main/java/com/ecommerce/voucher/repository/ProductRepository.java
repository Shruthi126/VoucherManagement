package com.ecommerce.voucher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.voucher.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,String>{

}
