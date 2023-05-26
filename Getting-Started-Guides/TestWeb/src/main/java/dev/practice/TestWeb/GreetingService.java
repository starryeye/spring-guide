package dev.practice.TestWeb;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greeting() {
        return "Hello, Mock";
    }
}
