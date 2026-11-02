package org.vedantacomp.saga.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.vedantacomp.common.dto.SagaOrchestratorStatus;
import org.vedantacomp.common.dto.SagaStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "saga_transactions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Saga {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private Long bookingId;
    
    @Column(nullable = false)
    private Long showId;

    @Column
    private String seatNumber;

    @Column(nullable = false)
    BigDecimal amount;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SagaOrchestratorStatus status;

    @Column
    @Enumerated(EnumType.STRING)
    private SagaStatus sagaStatus;
    @Column
    private Long paymentId;

    @Column(nullable = true)
    private String failureReason;
   
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
