package com.example.multimodule.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(ServiceProperties.class)
public class MyService {

    private final ServiceProperties properties;

    public MyService(ServiceProperties properties) {
        this.properties = properties;
    }

    public String getPropertiesMessage() {
        return properties.getMessage();
    }
}
