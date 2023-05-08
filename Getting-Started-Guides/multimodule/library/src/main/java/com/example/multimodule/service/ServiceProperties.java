package com.example.multimodule.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "service")
public class ServiceProperties {

    private final String message;

    public ServiceProperties(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
