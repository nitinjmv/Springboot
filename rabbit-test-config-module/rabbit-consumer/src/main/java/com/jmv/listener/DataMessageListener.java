package com.jmv.listener;

import com.jmv.config.DataQueueConfig;
import com.jmv.dto.MsgDTO;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataMessageListener {

    private final RabbitTemplate rabbitTemplate;

    public DataMessageListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @RabbitListener(queues = DataQueueConfig.DATA_QUEUE)
    public void handleDataQueue(MsgDTO msg) {
        System.out.println("Received from data-queue: " + msg);
        if (msg.isStatus()) {
            throw new AmqpRejectAndDontRequeueException("Data queue processing failed");
        }
    }

    @RabbitListener(queues = DataQueueConfig.DATA_DLQ)
    public void handleDataDlq(MsgDTO msg) {
        System.out.println("DATA DLQ received: " + msg);
        if (isMalformed(msg)) {
            rabbitTemplate.convertAndSend("", DataQueueConfig.DATA_ORPHAN, msg);
            System.out.println("Sent to DATA ORPHAN queue");
        } else {
            rabbitTemplate.convertAndSend("", DataQueueConfig.DATA_PARKING, msg);
            System.out.println("Sent to DATA PARKING queue");
        }
    }

    private boolean isMalformed(MsgDTO msg) {
        return msg.getId() == null || msg.getName() == null;
    }
}
