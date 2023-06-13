package dev.practice.TestWeb;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @WebMvcTest 는 Spring MVC Controller 에 집중된 Test 방법이다.
 * - @Controller, @ControllerAdvice, @JsonComponent,
 * Filter, WebMvcConfigurer, HandlerMethodArgumentResolver 등의 Bean 만 로드한다.
 * - MockMvc Bean 을 생성하여 로드한다.
 * @SpringBootTest 가 없어서 Spring Boot Application 전체 컨텍스트가 띄워지지 않으므로, 스프링 빈이 주입될 수 없다.
 * 그래서, @Service, @Component 등의 빈을 이용하기 위해서는 Mock 객체를 이용해야 한다. -> WebMockTest.java
 *
 * @WebMvcTest 는 @SpringBootTest + @AutoConfigurationMockMvc 조합 보다 로딩이 단순하여 Test 수행 속도가 빠르다.
 */
@WebMvcTest(controllers = HomeController.class)
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * TestWebApplication 과 동일
     */
    @Test
    void shouldReturnDefaultMessage() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.containsString("Hello, World")
                ));
    }
}
