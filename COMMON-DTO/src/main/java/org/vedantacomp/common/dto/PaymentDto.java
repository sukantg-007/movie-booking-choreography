package org.vedantacomp.common.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private Long id;
    private UUID sagaId;
    private Long bookingId;
    private BigDecimal amount;
    private String method;
    private PaymentStatus status;
    private String transactionId;
    private LocalDateTime createdAt;
}
