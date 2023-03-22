package com.snocal.sms.conf.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.snocal.sms.conf.core.controller", "com.snocal.sms.module.controller" })
@EntityScan(basePackages = { "com.snocal.sms.conf.auth.entity" })
public class SnocalSmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnocalSmsApplication.class, args);
	}

}
