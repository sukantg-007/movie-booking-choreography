package org.vedantacomp.common.dto;

import java.math.BigDecimal;
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
public class SagaDto {

	 	private UUID id;
	    private Long bookingId;
	    private Long seatId;
	    private Long showId;
	    private String seatNumber;
	    BigDecimal amount;
	    private SagaOrchestratorStatus status;
	    private SagaStatus sagaStatus;
	    private Long paymentId;
	    private String failureReason;
}
