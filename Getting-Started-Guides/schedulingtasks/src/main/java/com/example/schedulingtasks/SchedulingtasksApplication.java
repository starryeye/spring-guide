package com.example.schedulingtasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //스케줄러를 활성화
public class SchedulingtasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulingtasksApplication.class, args);
	}

}
