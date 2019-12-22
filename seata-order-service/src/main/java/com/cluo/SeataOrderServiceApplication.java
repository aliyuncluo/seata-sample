package com.cluo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages="com.cluo.dao")
public class SeataOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataOrderServiceApplication.class, args);
	}

}
