package com.example.multimodule.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "service.message=Hello")
public class MyServiceTest {

    @Autowired
    private MyService myService;

    @Test
    public void contextLoads() {
        Assertions.assertThat(myService.getPropertiesMessage()).isNotNull();
    }

    @SpringBootApplication
    static class TestConfiguration {
    }

}
