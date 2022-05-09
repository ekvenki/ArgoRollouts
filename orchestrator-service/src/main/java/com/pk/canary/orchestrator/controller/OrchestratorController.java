package com.pk.canary.orchestrator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orchestrator")
public class OrchestratorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrchestratorController.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${VERSION}")
    private String version;

    @GetMapping("/data")
    public String getTargetData() {

    	LOGGER.info("Initiating call to target microservice");
        String targetResponse = restTemplate.getForObject("http://target-service:8080/target/data", String.class);        
        LOGGER.info("Received target response:{}", targetResponse);
        
        String targetData = new StringBuilder().append("Orchestrator ").append(version).append(" initiated call to target microservice. ").append(" Received response:  ").append(targetResponse).toString();
        
        return targetData;
    }
}
