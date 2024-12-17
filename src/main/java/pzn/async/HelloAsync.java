package pzn.async;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

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

    //build future
    //just add name of executor to use executor that we made
    @Async("singleTaskExecutor")
    @SneakyThrows
    public Future<String> hello(final String name) {
        CompletableFuture<String> future = new CompletableFuture<>();
        Thread.sleep(Duration.ofSeconds(2));
        future.complete("Hello " + name + " from " + Thread.currentThread());
        return future;
    }
    //hello future will be use single task executor now, not default (the virtual executor)
}
