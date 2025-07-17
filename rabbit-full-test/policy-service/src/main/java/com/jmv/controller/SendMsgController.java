package com.jmv.controller;

import com.jmv.dto.Msg;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/policy/send")
public class SendMsgController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${amqp.exchange}")
    String exchange;

    @Value("${amqp.routing.key}")
    String routingKey;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendMsg(@RequestBody Msg msg) {
        rabbitTemplate.convertAndSend(exchange, routingKey, msg);
        return ResponseEntity.ok("Sent");
    }
}
