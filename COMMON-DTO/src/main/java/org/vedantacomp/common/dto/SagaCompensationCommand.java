package org.vedantacomp.common.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;

@Builder
public record SagaCompensationCommand(
		UUID sagaId,
		Long bookingId,
		Long showId,
		String failureReason,
		String seatNumber,
		BigDecimal amount,
		SagaStatus status		
		) {

}
