package com.laba.MobilMarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MobilMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobilMarketApplication.class, args);
	}

}
