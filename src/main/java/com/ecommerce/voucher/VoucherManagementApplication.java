package com.ecommerce.voucher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.ecommerce.voucher.auth.SecurityConfiguration;

@SpringBootApplication
@Import({ SecurityConfiguration.class })
public class VoucherManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoucherManagementApplication.class, args);
	}

}
