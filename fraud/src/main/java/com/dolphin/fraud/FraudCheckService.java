package com.dolphin.fraud;

import com.dolphin.clients.fraud.FraudClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }

    public boolean isFraudulentCustomer(Integer id) {
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .customerId(id)
                .build());

        return false;
    }
}
