package dev.practice.TestWeb;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private HomeController homeController;

    @Test
    void contextLoads() {
        Assertions.assertThat(homeController).isNotNull();
    }

    /**
     * 정리..
     *
     * @SpringBootTest 는 스프링 컨테이너가 띄워진다.
     * - 기본 옵션은 @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) 이다.
     * - 이는 서블릿 컨테이너를 구동하지 않고, MockServletContext 를 생성한다.
     * - MockServletContext 는 실제 서블릿 컨테이너와 비슷한 기능을 제공한다.
     *
     * - @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 는 실제 내장 톰캣 서버가 랜덤 포트로 띄워진다.
     *
     * @AutoConfigureMockMvc 는 MockMvc 인스턴스를 생성하고 웹 계층을 모의 테스트 할 수 있도록 돕는다.
     * - 즉, HTTP 요청과 응답을 모방하여 실제 웹 서버(톰캣)를 띄우지 않고도 웹 계층을 테스트하는 것이 가능하다.
     * - MockMvc 를 스프링 컨테이너에 자동으로 등록해준다.
     *
     * @WebMvcTest 는 웹 계층만 테스트한다.
     * - @WebMvcTest 는 @Controller, @ControllerAdvice 등을 사용할 수 있다. (Service, Component, Repository 는 사용할 수 없다.)
     * - 스프링 컨테이너 전체가 실행되지 않기 때문에 @SpringBootTest 보다 빠르게 테스트가 가능하다.
     * - MockMvc 를 스프링 컨테이너에 자동으로 등록해준다.
     * - 그래서 @MockBean 으로 Mock 객체를 의존성 주입해주고 사용한다. (유닛 테스트)
     */
}
