package dev.practice.TestWeb;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @SpringBootTest 로 Spring Boot Application 전체 컨텍스트가 띄워진다.
 * @AutoConfigureMockMvc 로 띄워진 컨텍스트내에 MockMvc 인스턴스를 생성하고 웹 계층을 모의 테스트 할 수 있도록 돕는다.
 * 즉, HTTP 요청과 응답을 모방하여 실제 서버를 띄우지 않고도 웹 계층을 테스트하는 것이 가능하다.
 *
 * @SpringBootTest + @AutoConfiguration 조합은
 * @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 보다 로딩이 단순하여
 * Test 수행 속도가 빠르다.
 */
@SpringBootTest
@AutoConfigureMockMvc
class TestWebApplicationTest {

	@Autowired
	private MockMvc mockMvc;

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
