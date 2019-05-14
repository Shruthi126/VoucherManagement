package com.ecommerce.voucher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.voucher.entity.Product;
import com.ecommerce.voucher.repository.ProductRepository;
@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getProducts(){
		List<Product> productList= new ArrayList<Product>();
		 productRepository.findAll().forEach(productList::add);
		
		 return productList;
	}
	
	public Product createProducts(Product product) {
		return productRepository.save(product);
		
	}
	
	public Product getProductById(String productId) {
		return productRepository.findById(productId).orElse(null);
		
	}
	
	public List<Product> getMultpileProductById(List<String> productId) {
			List<Product> prods= new ArrayList<Product>();
		  productRepository.findAllById(productId).forEach(a->prods.add(a));
		  return prods;
	}
	

}
