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
 *
 * @SpringBootTest 는 Spring Boot Application 의 전체 컨텍스트를 띄운다.
 * @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 는
 * 실제 내장 톰캣 서버가 띄워진다. 실제 HTTP 서버 환경에서 Test 가 이루어진다.
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
