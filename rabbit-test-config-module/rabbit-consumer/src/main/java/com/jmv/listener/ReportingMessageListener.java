package com.jmv.listener;

import com.jmv.config.ReportingQueueConfig;
import com.jmv.dto.MsgDTO;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReportingMessageListener {

    private final RabbitTemplate rabbitTemplate;

    public ReportingMessageListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @RabbitListener(queues = ReportingQueueConfig.REPORTING_QUEUE)
    public void handleReportingQueue(MsgDTO msg) {
        System.out.println("Received from reporting-queue: " + msg);
        if (msg.isStatus()) {
            throw new AmqpRejectAndDontRequeueException("Reporting queue processing failed");
        }
    }

    @RabbitListener(queues = ReportingQueueConfig.REPORTING_DLQ)
    public void handleReportingDlq(MsgDTO msg) {
        System.out.println("REPORTING DLQ received: " + msg);
        if (isMalformed(msg)) {
            rabbitTemplate.convertAndSend("", ReportingQueueConfig.REPORTING_ORPHAN, msg);
            System.out.println("Sent to REPORTING ORPHAN queue");
        } else {
            rabbitTemplate.convertAndSend("", ReportingQueueConfig.REPORTING_PARKING, msg);
            System.out.println("Sent to REPORTING PARKING queue");
        }
    }

    private boolean isMalformed(MsgDTO msg) {
        return msg.getId() == null || msg.getName() == null;
    }

}
