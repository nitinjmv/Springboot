package com.jmv;

import com.jmv.dto.Msg;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


@Component
public class AuditListener {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "${amqp.queue}")
    public void listener(Msg msg){
        System.out.println("Received "+msg);
    }
}
