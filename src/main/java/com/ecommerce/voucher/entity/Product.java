package com.ecommerce.voucher.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.PersistenceConstructor;
import lombok.Data;

@Document
@Data
public class Product {
	
	@Id
	private String productId;
	
	private String name;
	
	private String version;
	
	private BigDecimal price;
	
	private float rating;
	
	
	public Product() {
		super();
	}

	@PersistenceConstructor
	public Product(String productId, String name, String version, BigDecimal price, float rating) {
		super();
		this.productId = productId;
		this.name = name;
		this.version = version;
		this.price = price;
		this.rating = rating;
	}
	
	
	public boolean equals(Product product) {
			if (this == product)
				return true;
			if (product == null)
				return false;
			
			return (this.name.equals(product.name)&& this.version.equals(product.version)) ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	
	
	
	
}
