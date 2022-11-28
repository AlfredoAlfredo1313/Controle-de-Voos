package com.mosz.ctrl_voos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.mosz" })
@EntityScan(basePackages = { "com.mosz" })
public class CtrlVoosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtrlVoosApplication.class, args);
	}
}
