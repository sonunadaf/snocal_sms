package com.snocal.sms.conf.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.snocal.sms.conf.core.controller", "com.snocal.sms.module.controller","com.snocal.sms.conf.core.service" })
@EntityScan(basePackages = { "com.snocal.sms.conf.core.entity", })
@EnableJpaRepositories(basePackages = { "com.snocal.sms.conf.core.repository" })
public class SnocalSmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnocalSmsApplication.class, args);
	}

}
