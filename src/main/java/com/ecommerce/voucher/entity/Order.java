package com.ecommerce.voucher.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

import lombok.Data;

@Document @Data
public class Order extends ResourceSupport {
	
	@Id
	private String orderId;
	
	private BigDecimal totalAmount;
	
	private Timestamp createdOn;
	
	private Timestamp expectedDeliveryOn;
	
	private List<PaymentMode> paymentModes;
	
	private String customerId;
	
	private Map<String,Integer> products;
	
	private Address deliveryAddress;

	public Order() {
		super();
	}
	
	@PersistenceConstructor
	public Order(String orderId, BigDecimal totalAmount, Timestamp createdOn, Timestamp expectedDeliveryOn,
			List<PaymentMode> paymentModes, String customerId, Map<String, Integer> products, Address deliveryAddress) {
		super();
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.createdOn = createdOn;
		this.expectedDeliveryOn = expectedDeliveryOn;
		this.paymentModes = paymentModes;
		this.customerId = customerId;
		this.products = products;
		this.deliveryAddress=deliveryAddress;
	}

	

}
