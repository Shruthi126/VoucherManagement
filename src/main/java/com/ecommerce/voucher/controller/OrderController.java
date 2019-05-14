package com.ecommerce.voucher.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.voucher.entity.Order;
import com.ecommerce.voucher.service.OrderService;

@RestController
@RequestMapping
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,path = "/orders")
	 List<Order> getOrders() {
		
		return orderService.getOrders();
	}
	

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,path="/orders")
		 Order createOrder(@RequestBody Order order)  {
			return orderService.createOrders(order);
			
		}



  @GetMapping( path= "/orders/{id}",produces =MediaType.APPLICATION_JSON_UTF8_VALUE) 
  Order getOrderById(@PathVariable("id") String orderId) { 
	 
	  return orderService.getOrderById(orderId); 
 }
}
 