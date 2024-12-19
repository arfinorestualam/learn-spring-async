package pzn.async;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobTest {

    @Autowired
    private Job job;

    @Test
    void job() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(5));
        //testing for schedule, if look at the parameter, with max time is 5 seconds
        //method job will run 2 times, cause the second will be take 2 times too
        assertEquals(2L, job.getValue());
        //fyi, schedule will run automatically when spring start, no need to run manually
    }

}