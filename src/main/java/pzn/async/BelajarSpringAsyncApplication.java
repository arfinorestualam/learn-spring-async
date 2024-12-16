package pzn.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

//to enable async in spring boot, just add this annotation:
@EnableAsync
@SpringBootApplication
public class BelajarSpringAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(BelajarSpringAsyncApplication.class, args);
    }

}
