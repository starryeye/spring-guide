package com.example.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingrestApplication {

	private static final Logger logger = LoggerFactory.getLogger(ConsumingrestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingrestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		/**
		 * new 를 통해서 생성할 수 도 있지만, Spring boot 가 제공하는 RestTemplateBuilder 를 통해서 생성
		 */
		return builder.build(); //builder 를 통해서 여러가지 인증/보안/base url 등을 설정할 수 있다.
	}

	@Bean
	ApplicationRunner run(RestTemplate restTemplate) {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"http://localhost:8080/api/random", Quote.class);
			logger.info("Response : {}", quote.toString());
		};
	}

}
