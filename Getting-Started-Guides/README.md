# Getting Started Guides  
Designed to be completed in 15-30 minutes  
https://spring.io/guides#gettingStarted  


## 1. Building a RESTful Web Service  
  
Learn how to create a RESTful web service with Spring.  
https://spring.io/guides/gs/rest-service/  
  
project : restservice  
new
- record type
- MockMvc


## 2. Scheduling Tasks
  
Learn how to schedule tasks with Spring.  
https://spring.io/guides/gs/scheduling-tasks/  

project : schedulingtasks  
new
- @Scheduled
- @EnableScheduling
- @SpyBean
- awaitility library


## 3. Consuming a RESTful Web Service
  
Learn how to retrieve web page data with Spring's RestTemplate.  
https://spring.io/guides/gs/consuming-rest/  
  
project : consumingrest  
new  
- server.port=0  
- RestTemplateBuilder  
- Server project providing API : https://github.com/spring-guides/quoters  

## 4. Accessing Relational Data using JDBC with Spring
  
Learn how to access relational data with Spring.  
https://spring.io/guides/gs/relational-data-access/  
  
project : relationaldataaccess  
new  
- JdbcTemplate, NamedParameterJdbcTemplate  
- MapSqlParameterSource, BeanPropertySqlParameterSource  

## 5. Creating a Multi Module Project
  
Learn how to build a library and package it for consumption in a Spring Boot application.  
https://spring.io/guides/gs/multi-module/  
  
project : multimodule  
new  
- ConfigurationProperties, EnableConfigurationProperties  
- Spring boot multi module  
  
## 6. Testing the Web Layer
  
Learn how to test Spring Boot applications and MVC controllers.  
https://spring.io/guides/gs/testing-web/  

project : TestWeb  
new  
- @SpringBootTest, Smoke test
- @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
- @SpringBootTest + @AutoConfigurationMockMvc
- @WebMvcTest
- @WebMvcTest + @MockBean
  
