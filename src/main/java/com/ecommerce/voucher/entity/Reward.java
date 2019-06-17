package com.ecommerce.voucher.entity;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

import lombok.Data;

@Document@Data
public class Reward extends ResourceSupport{

	@Id
	private String rewardId;
	
	private Date expiryDate;
	
	//TODO how to add currency
	
	private Integer rewardPoints;
	
	private String customerId;
	
	public Reward() {
		super();
	}
	
	public Reward(String rewardId,  Date expiryDate, Integer rewardPoints) {
		super();
		this.rewardId = rewardId;
		this.expiryDate = expiryDate;
		this.rewardPoints = rewardPoints;
	}
	
}
