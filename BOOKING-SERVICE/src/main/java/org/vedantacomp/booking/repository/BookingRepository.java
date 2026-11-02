package org.vedantacomp.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vedantacomp.booking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
