package com.jmv.service;

import com.jmv.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageReceiver {

    private final RabbitTemplate rabbitTemplate;
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiver(String msg){
        System.out.println("Message received: " + msg);
    }
}
