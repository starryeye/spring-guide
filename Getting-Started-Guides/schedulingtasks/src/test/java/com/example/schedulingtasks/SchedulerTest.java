package com.example.schedulingtasks;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class SchedulerTest {

    @SpyBean
    ScheduledTasks scheduledTasks;

    /**
     * 10 초 내에 최소 2번 실행되는지 확인
     */
    @Test
    void reportCurrentTime() {
        await().atMost(10, SECONDS).untilAsserted(() -> {
            verify(scheduledTasks, atLeast(2)).reportCurrentTime();
        });
    }
}
