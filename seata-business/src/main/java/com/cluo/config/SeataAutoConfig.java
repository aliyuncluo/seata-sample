package com.cluo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.seata.spring.annotation.GlobalTransactionScanner;

@Configuration
public class SeataAutoConfig {
    /**
     * seata 服务分组，要与服务端nacos-config.txt中service.vgroup_mapping的后缀对应  my_test_tx_group
     * @return
     */
	@Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner("${spring.application.name}", "my_test_tx_group");
    }
}
