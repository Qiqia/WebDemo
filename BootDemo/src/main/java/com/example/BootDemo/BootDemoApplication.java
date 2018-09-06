package com.example.BootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootDemoApplication {

	public static void main(String[] args) {
		//原始的springBoot启动
        //SpringApplication.run(BootDemoApplication.class, args);
		SpringApplication app = new SpringApplication(BootDemoApplication.class);
		//用户拓展项
		//app.setAdditionalProfiles();
		app.run(args);
	}
}
