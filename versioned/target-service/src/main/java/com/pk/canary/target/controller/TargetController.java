package com.pk.canary.target.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/target")
public class TargetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TargetController.class);

    @Value("${VERSION}")
    private String version;

    @GetMapping("/data")
    public String getData() {

    	LOGGER.info("Target microservice with version={}", version);
    	String targetData = new StringBuilder().append("Target microservice responding with version: ").append(version).append(" . I'm the enhanced version").toString();
        return targetData;
    }

}
