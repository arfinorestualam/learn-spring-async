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


    //rules of cron expression
    // * * * * * *
    // first * is second (0-59)
    // second * is minute (0-59)
    // third * is hour (0-23)
    // fourth * is day of the month (1-31)
    // fifth * is month (1-12) or (JAN - DEC)
    // sixth * is day of the week (0-7), (0 or 7 is Sunday, or MON-SUN)
    // if you want to exercise go to crontab.guru

    //use cron on schedule is like this :
    @Scheduled(cron = "* * * * * *") //it means every second
    //"*/2 * * * * *" it means run every 2 seconds
    public void scheduleCron() {
        log.info("run cron job every second");
    }
}
