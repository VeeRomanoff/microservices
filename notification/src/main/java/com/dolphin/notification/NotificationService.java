package com.dolphin.notification;

import com.dolphin.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .message(notificationRequest.message())
                .sender("Dolphin")
                .sentAt(LocalDateTime.now())
                .toCustomerEmail(notificationRequest.customerEmail())
                .toCustomerId(notificationRequest.customerId())
                .build();

        notificationRepository.save(notification);
    }
}
