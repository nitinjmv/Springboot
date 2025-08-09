package com.jmv.config;

import org.springframework.amqp.core.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean()
public class ReportingQueueConfig {

    public static final String REPORTING_QUEUE = "reporting-queue";
    public static final String REPORTING_KEY = "reporting-key";

    public static final String REPORTING_DLQ = "reporting-queue.dlq";
    public static final String REPORTING_DLQ_KEY = "reporting-queue.dlq";

    public static final String REPORTING_ORPHAN = "reporting-queue.orphan";
    public static final String REPORTING_PARKING = "reporting-queue.parking";

    @Bean
    public Queue reportingQueue() {
        return QueueBuilder.durable(REPORTING_QUEUE)
                .withArgument("x-dead-letter-exchange", CommonRabbitConfig.DLX_EXCHANGE)
                .withArgument("x-dead-letter-routing-key", REPORTING_DLQ_KEY)
                .build();
    }

    @Bean
    public Queue reportingDlqQueue() {
        return QueueBuilder.durable(REPORTING_DLQ).build();
    }

    @Bean
    public Queue reportingOrphanQueue() {
        return new Queue(REPORTING_ORPHAN, true);
    }

    @Bean
    public Queue reportingParkingQueue() {
        return new Queue(REPORTING_PARKING, true);
    }

    @Bean
    public Binding bindReportingQueue() {
        return BindingBuilder.bind(reportingQueue())
                .to(new DirectExchange(CommonRabbitConfig.EXCHANGE))
                .with(REPORTING_KEY);
    }

    @Bean
    public Binding bindReportingDlq() {
        return BindingBuilder.bind(reportingDlqQueue())
                .to(new DirectExchange(CommonRabbitConfig.DLX_EXCHANGE))
                .with(REPORTING_DLQ_KEY);
    }
}