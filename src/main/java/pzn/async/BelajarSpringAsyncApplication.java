package pzn.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//to enable async in spring boot, just add this annotation:
@EnableAsync
//to enable scheduler in spring boot, just add this annotation:
@EnableScheduling
@SpringBootApplication
public class BelajarSpringAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(BelajarSpringAsyncApplication.class, args);
    }

}
