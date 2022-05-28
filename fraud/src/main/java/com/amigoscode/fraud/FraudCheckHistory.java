package com.amigoscode.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
public class FraudCheckHistory {
  @Id
  @SequenceGenerator(
      name = "fraud_id_sequence",
      sequenceName = "fraud_id_sequence"
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "fraud_id_sequence"
  )
  private Integer id;
  private Integer customerId;
  private Boolean isFraudster;
  private LocalDateTime createdAt;
}
