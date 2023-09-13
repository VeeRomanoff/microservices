package com.dolphin.customer;

import com.dolphin.clients.fraud.FraudCheckResponse;
import com.dolphin.clients.fraud.FraudClient;
import com.dolphin.clients.notification.NotificationClient;
import com.dolphin.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;


    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //TODO: check if email is valid
        //TODO: check if email is not taken

        repository.saveAndFlush(customer);

        //TODO: check if fraudster
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster!");
        }

        //TODO: send notification

        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        "Welcome, %s".formatted(customer.getFirstName())
                )
        );
    }
}
