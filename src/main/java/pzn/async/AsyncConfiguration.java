package pzn.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
public class AsyncConfiguration {

    //if you want to use thread executor custom, do this, if you do this
    //spring will use this and not build thread executor automatically
    @Bean
    public Executor taskExecutor() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }
    //must bean, and the name must be taskExecutor, and will be default

    //dynamic executor, we can use executor that we made dynamically
    @Bean
    public Executor singleTaskExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    //if you want to custom executor for scheduler, first you make @Bean
    @Bean
    //using ScheduledExecutorService and the name must include taskScheduler in full name
    public ScheduledExecutorService taskScheduler() {
        return Executors.newScheduledThreadPool(10);
    }
    //same with custom thread for async, if you make the custom, will be replace
    //the default setting that set in .properties file
}
