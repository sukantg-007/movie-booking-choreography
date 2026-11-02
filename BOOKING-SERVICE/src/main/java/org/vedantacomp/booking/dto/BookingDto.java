package org.vedantacomp.booking.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.vedantacomp.common.dto.BookingStatus;

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
public class BookingDto {

    private Long id;
    private Long userId;
    private Long showId;
    private String seatNumber;
    private BookingStatus status;
    private BigDecimal amount;
    private LocalDateTime createdAt;
}
