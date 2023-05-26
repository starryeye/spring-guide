package dev.practice.TestWeb;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * WebLayerTest 의 현실적인 버전이다. 대부분의 Controller 는 다른 Service 객체를 의존하고 의존성 주입이 필요하다.
 * Spring Boot Application 컨텍스트를 띄우지 않았으므로,
 * @Service 의 Bean 을 이용하기 위해서는 @MockBean 으로 모의 객체를 이용해야 한다.
 *
 * Test 의 책임에 대해 좀 더 생각해볼 필요가 있다.
 * 이전에 개발해본 코드로 가서 기억을 상기 시켜 보자.
 * https://github.com/starryeye/architecture/blob/main/hexagonal/pay/src/test/java/dev/practice/pay/account/adapter/in/web/SendMoneyControllerTest.java
 */
@WebMvcTest(controllers = GreetingController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService greetingService;

    @Test
    void greetingShouldReturnMessageFromService() throws Exception {

        //MockBean 의 행동을 미리 지정해준다.
        Mockito.when(greetingService.greeting()).thenReturn("Hello, Mock");

        mockMvc.perform(MockMvcRequestBuilders.get("/greeting"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.containsString("Hello, Mock")
                ));
    }
}
