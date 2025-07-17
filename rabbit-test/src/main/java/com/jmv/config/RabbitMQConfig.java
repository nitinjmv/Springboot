package com.jmv.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    public static final String QUEUE = "my-queue";
    public static final String ORPHAN_QUEUE = "orphan-queue";
    public static final String  PARKING_QUEUE = "parking-queue";
    public static final String DLQ = "dlq";
    @Bean
    public Queue queue(){
        return new Queue(QUEUE, false);
    }

    @Bean
    public Queue orphanQueue() {
        return new Queue(ORPHAN_QUEUE);
    }

    @Bean
    public Queue parkingQueue() {
        return new Queue(PARKING_QUEUE);
    }


}
