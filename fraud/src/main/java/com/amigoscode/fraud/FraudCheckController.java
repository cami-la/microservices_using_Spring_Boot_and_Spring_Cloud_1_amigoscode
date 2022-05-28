package com.amigoscode.fraud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/fraud-check")
@RestController
@Slf4j
public record FraudCheckController(FraudCheckService fraudCheckService) {

  @GetMapping(path = "{customerId}")
  public FraudCheckResponse isFraudster(
      @PathVariable("customerId") Integer customerId) {
    boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
    log.info("fraud check request for customer {}", customerId);
    return new FraudCheckResponse(isFraudulentCustomer);
  }

}
