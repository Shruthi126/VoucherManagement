package com.ecommerce.voucher.util;

public class Constants {

	public enum Status {
		SUCCESS("200") ,FAIL("500");
		private final String value;
		
		private Status(String value) {
			this.value=value;
		}
		public String getValue() {
			return value;
		}
		 	
	}

}
