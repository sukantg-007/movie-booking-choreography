package org.vedantacomp.common.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;

@Builder
public record SeatDto (
		Long id,
		UUID sagaId,
		Long bookingId,
		Long showId,
		String seatNumber,
		SeatStatus status,
		BigDecimal amount,
		LocalDateTime createdAt
		
		) {
}
