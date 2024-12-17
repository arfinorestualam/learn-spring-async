package pzn.async;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
public class HelloAsync {

    //just add annotation @Async so the method automatically became asynchronous
    @Async
    //automatic throw using this annotation:
    @SneakyThrows
    public void hello() {
        Thread.sleep(Duration.ofSeconds(2));
        log.info("hello after 2 seconds {}", Thread.currentThread());
    }
}
