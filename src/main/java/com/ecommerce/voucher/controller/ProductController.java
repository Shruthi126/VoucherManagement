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

import com.ecommerce.voucher.entity.Product;
import com.ecommerce.voucher.service.ProductService;

@RestController
@RequestMapping
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,path = "/products")
	 List<Product> getProducts() {
		
		return productService.getProducts();
	}
	

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,path="/products")
		 Product createProduct(@RequestBody Product product)  {
			return productService.createProducts(product);
			
		}



	//Mistake done :@PathParam is wrong @PathVariable is right
  @GetMapping( path= "/products/{id}",produces =MediaType.APPLICATION_JSON_UTF8_VALUE) 
  Product getProductById(@PathVariable("id") String productId) { 
	 
	  return productService.getProductById(productId); 
 }
}
 