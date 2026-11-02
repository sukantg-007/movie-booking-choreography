package org.vedantacomp.seat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vedantacomp.common.dto.SeatStatus;
import org.vedantacomp.seat.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
	
	Optional<Seat> findBySeatNumberAndShowIdAndStatus(String seatNumber, Long showId, SeatStatus status);

	Optional<Seat> findBySeatNumberAndShowId(String seatNumber, Long showId);
}
