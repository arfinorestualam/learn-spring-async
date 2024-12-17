package pzn.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@Slf4j
@SpringBootTest
class HelloAsyncTest {

    @Autowired
    private HelloAsync helloAsync;

    @Test
    void hello() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            helloAsync.hello();
        }
        //this code below will be shown first to prove the code running async
        log.info("after call helloAsync");
        Thread.sleep(Duration.ofSeconds(5));
    }

}