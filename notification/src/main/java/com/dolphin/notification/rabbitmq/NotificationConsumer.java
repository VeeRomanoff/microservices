package com.dolphin.notification.rabbitmq;

import com.dolphin.clients.notification.NotificationRequest;
import com.dolphin.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer(NotificationRequest request) {
        log.info("consumed {} from queue", request);
        notificationService.sendNotification(request);
    }
}
