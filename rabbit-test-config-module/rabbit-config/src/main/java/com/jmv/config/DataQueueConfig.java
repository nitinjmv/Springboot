package com.jmv.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataQueueConfig {

    public static final String DATA_QUEUE = "data-queue";
    public static final String DATA_KEY = "data-key";

    public static final String DATA_DLQ = "data-queue.dlq";
    public static final String DATA_DLQ_KEY = "data-queue.dlq";

    public static final String DATA_ORPHAN = "data-queue.orphan";
    public static final String DATA_PARKING = "data-queue.parking";

    @Bean
    public Queue dataQueue() {
        return QueueBuilder.durable(DATA_QUEUE)
                .withArgument("x-dead-letter-exchange", CommonRabbitConfig.DLX_EXCHANGE)
                .withArgument("x-dead-letter-routing-key", DATA_DLQ_KEY)
                .build();
    }

    @Bean
    public Queue dataDlqQueue() {
        return QueueBuilder.durable(DATA_DLQ).build();
    }

    @Bean
    public Queue dataOrphanQueue() {
        return new Queue(DATA_ORPHAN, true);
    }

    @Bean
    public Queue dataParkingQueue() {
        return new Queue(DATA_PARKING, true);
    }

    @Bean
    public Binding bindDataQueue() {
        return BindingBuilder.bind(dataQueue())
                .to(new DirectExchange(CommonRabbitConfig.EXCHANGE))
                .with(DATA_KEY);
    }

    @Bean
    public Binding bindDataDlq() {
        return BindingBuilder.bind(dataDlqQueue())
                .to(new DirectExchange(CommonRabbitConfig.DLX_EXCHANGE))
                .with(DATA_DLQ_KEY);
    }
}