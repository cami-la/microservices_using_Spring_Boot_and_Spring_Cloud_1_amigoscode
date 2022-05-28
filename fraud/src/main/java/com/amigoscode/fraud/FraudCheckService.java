package com.amigoscode.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public record FraudCheckService(
    FraudCheckHistoryRepository fraudCheckHistoryRepository
) {

  public boolean isFraudulentCustomer(Integer customerId) {
    fraudCheckHistoryRepository.save(
        FraudCheckHistory.builder()
            .customerId(customerId)
            .isFraudster(false)
            .createdAt(LocalDateTime.now())
            .build());
    return false;
  }
}
