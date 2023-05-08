package com.example.multimodule.application;

import com.example.multimodule.service.MyService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyControllerTest {

    @Autowired
    private MyService myService;

    @Test
    public void contextLoads() {
        Assertions.assertThat(myService.getPropertiesMessage()).isNotNull();
    }

}
