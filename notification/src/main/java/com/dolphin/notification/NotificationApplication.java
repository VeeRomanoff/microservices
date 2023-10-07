package com.dolphin.notification;

import com.dolphin.amqp.RabbitMQConfig;
import com.dolphin.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.dolphin.notification",
                "com.dolphin.amqp",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.dolphin.clients"
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(NotificationConfig config, RabbitMQMessageProducer prod) {
//        return args -> {
//            prod.publish(
//                    "Foo",
//                    config.getInternalExchange(),
//                    config.getRoutingKey()
//            );
//        };
//    }
//
//    record Soda(String brand, double price) {}
}

