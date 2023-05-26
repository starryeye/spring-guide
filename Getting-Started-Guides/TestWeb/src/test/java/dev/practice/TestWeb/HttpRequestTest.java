package dev.practice.TestWeb;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * HTTP 요청 Test
 * Spring Web Application 전체를 띄운다.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void greetingShouldReturnDefaultMessage() {

        String response = testRestTemplate.getForObject(
                "http://localhost:%d/hello".formatted(port),
                String.class
        );

        Assertions.assertThat(response).contains("Hello, World");
    }
}
