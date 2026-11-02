package org.vedantacomp.common.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import lombok.Builder;
@Builder
public record BookingResponseDTO(
		    Long bookingId,
		    UserDto user,
		    ShowDto show,
		    String seatNumber,
		    BigDecimal amount,
		    BookingStatus status,
		    LocalDateTime bookedAt
		) {

}
