package com.vin;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages="com.vin")
public class ScheduledBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledBatchApplication.class, args);
	}
}

