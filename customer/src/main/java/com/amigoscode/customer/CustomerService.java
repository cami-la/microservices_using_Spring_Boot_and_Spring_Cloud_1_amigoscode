package com.amigoscode.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
  public void registerCustomer(CustomerRegistrationRequest request) {
    Customer customer = Customer.builder()
        .firstName(request.firstName())
        .lastName(request.lastName())
        .email(request.email())
        .build();
    //todo: check if email valid
    //todo: check if email not taken
    customerRepository.saveAndFlush(customer);
    //todo: check if fraudster
    FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
        "http://localhost:8081/api/v1/fraud-check/{customerId}",
        FraudCheckResponse.class,
        customer.getId()
    );
    assert fraudCheckResponse != null;
    if (fraudCheckResponse.isFraudster()) {
      throw new IllegalStateException("fraudster");
    }
    //todo: send notification
  }
}
