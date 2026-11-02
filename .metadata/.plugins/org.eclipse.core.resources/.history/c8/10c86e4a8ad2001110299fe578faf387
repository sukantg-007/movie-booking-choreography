package org.vedantacomp.saga.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vedantacomp.saga.entity.Saga;

public interface SagaRepository extends JpaRepository<Saga, UUID> {

	Saga findByBookingId(Long bookingId);
}
