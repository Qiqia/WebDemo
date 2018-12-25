package com.example.BootDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootDemoApplication {
	private final static Logger _logger = LoggerFactory.getLogger(BootDemoApplication.class);

	public static void main(String[] args) {
		//原始的springBoot启动
        //SpringApplication.run(BootDemoApplication.class, args);
		SpringApplication app = new SpringApplication(BootDemoApplication.class);
		//用户拓展项
		//app.setAdditionalProfiles();
		int x =88;
		_logger.info("整合日志：{}",x);
		app.run(args);
	}
}
