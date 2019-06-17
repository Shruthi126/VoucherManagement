package com.ecommerce.voucher.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ConfigurationUtility {

	@Autowired
	private static Environment env;
	
	public static String getProperty(String key) {
		return env.getProperty(key);
	}
}
