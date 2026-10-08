package com.ecogrid.settlementservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SettlementServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(SettlementServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SettlementServiceApplication.class, args);
        log.info("Settlement Service started successfully");
    }
}
