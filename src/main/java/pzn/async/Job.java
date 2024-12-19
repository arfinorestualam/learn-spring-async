package pzn.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
public class Job {
    private final AtomicLong counter = new AtomicLong(0);

    //just use annotation @Scheduled to transform method into schedule
    //for the parameter that can use, you can see doc, for now the example is using
    //initial delay and fixed delay
    @Scheduled(timeUnit = TimeUnit.SECONDS, initialDelay = 2, fixedDelay = 2)
    public void schedule() {
        //this method will run after 2 seconds and delay for next run is 2 seconds
        Long value = counter.incrementAndGet();
        log.info("{} Run job {}", value, Thread.currentThread().getName());
    }

    public Long getValue() {
        return counter.get();
    }
}