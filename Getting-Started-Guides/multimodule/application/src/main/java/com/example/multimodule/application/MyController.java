package com.example.multimodule.application;

import com.example.multimodule.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/service")
    public String service() {
        System.out.println("myService = " + myService.getPropertiesMessage());

        return myService.getPropertiesMessage();
    }
}
