package com.jmv.controller;

import com.jmv.config.CommonRabbitConfig;
import com.jmv.config.DataQueueConfig;
import com.jmv.config.ReportingQueueConfig;
import com.jmv.dto.MsgDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
@Slf4j
public class ProducerController {

    private final RabbitTemplate rabbitTemplate;

    public ProducerController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${rabbit.exchange.name}")
    private String exchange;

    @Value("${rabbit.data.routing-key}")
    private String dataRoutingKey;

    @Value("${rabbit.reporting.routing-key}")
    private String reportingRoutingKey;

    @PostMapping(value = "/data", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void sendData(@RequestBody MsgDTO msg) {
        rabbitTemplate.convertAndSend(CommonRabbitConfig.EXCHANGE, DataQueueConfig.DATA_KEY, msg);
        System.out.println("Sent data: " + msg);
    }

    @PostMapping(value = "/reporting", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void sendReporting(@RequestBody MsgDTO msg) {
        rabbitTemplate.convertAndSend(CommonRabbitConfig.EXCHANGE, ReportingQueueConfig.REPORTING_KEY, msg);
        System.out.println("Sent reporting: " + msg);
    }
}
