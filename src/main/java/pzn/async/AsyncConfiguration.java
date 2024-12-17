package pzn.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class AsyncConfiguration {

    //if you want to use thread executor custom, do this, if you do this
    //spring will use this and not build thread executor automatically
    @Bean
    public Executor taskExecutor() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }
    //must bean, and the name must be taskExecutor
}
