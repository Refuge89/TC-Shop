package com.chaouki.tcshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class KafkaConfig {

    @Bean
    public AsyncTaskExecutor taskExecutor(){
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(4);
        return taskExecutor;
    }
}
