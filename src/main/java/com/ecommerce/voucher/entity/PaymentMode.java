package com.ecommerce.voucher.entity;

public enum PaymentMode {
	CREDIT_CARD("CC"),DEBIT_CARD("DC"),UPI("UPI"),NET_BANKING("NB"),VOUCHER("VC"),REWARD_POINTS("RP");
	
	private String value;
	private PaymentMode(String value) {
		this.value=value;
	}
}
