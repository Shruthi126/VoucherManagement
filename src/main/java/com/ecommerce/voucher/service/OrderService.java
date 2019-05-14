package com.ecommerce.voucher.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.voucher.entity.Order;
import com.ecommerce.voucher.entity.Product;
import com.ecommerce.voucher.repository.CustomerRepository;
import com.ecommerce.voucher.repository.OrderRepository;
import com.ecommerce.voucher.repository.ProductRepository;
@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ProductRepository productRepository;
	
	public List<Order> getOrders(){
		List<Order> orderList= new ArrayList<Order>();
		 orderRepository.findAll().forEach(orderList::add);
		
		 return orderList;
	}
	
	public Order createOrders(Order order) {
		
		
		//Calculate total amount
		Map<String,Integer> prodsMap= order.getProducts();
		Iterable<Product> products=productRepository.findAllById(order.getProducts().keySet());
		BigDecimal totalAmount=new BigDecimal(0);
		for(Product prod:products) {
			totalAmount=prod.getPrice().multiply(new BigDecimal(prodsMap.get(prod.getProductId())));
		}
		order.setTotalAmount(totalAmount);
		
		order.setCreatedOn(new Timestamp(new Date().getTime()));
		
		//Calculate expected delivery date based on business logic. here setting i for 2 days
		order.setExpectedDeliveryOn(new Timestamp(new Date().getTime()+Long.valueOf("172800000")));
		
		return orderRepository.save(order);
		
	}
	
	public Order getOrderById(String orderId) {
		return orderRepository.findById(orderId).orElse(null);
		
	}
	

}
