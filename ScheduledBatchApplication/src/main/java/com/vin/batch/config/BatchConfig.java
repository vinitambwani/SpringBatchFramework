package com.vin.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {
	
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	PrintTasklet printTasklet;
	
	@Bean
	Job createJob() {
		return jobBuilderFactory.get("JDBC Job").incrementer(new RunIdIncrementer()).start(createPrintStep()).build();		
	}
	
	@Bean
	Step createPrintStep() {
		return stepBuilderFactory.get("Print Step").tasklet(printTasklet).build();
	}
}
