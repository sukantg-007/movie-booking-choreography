package org.vedantacomp.saga.service;

import java.util.UUID;

import org.vedantacomp.common.dto.BookingCreatedEvent;
import org.vedantacomp.common.dto.ProcessPaymentReply;
import org.vedantacomp.common.dto.SagaDto;
import org.vedantacomp.common.dto.SeatAllocationReply;

public interface SagaOrchestratorService {

    SagaDto getSagaByBookingId(Long bookingId);

	void handleBookingCreatedEvent(BookingCreatedEvent event);

	void handleSeatAllocationReply(SeatAllocationReply reply);

	void handleProcessPaymentReply(ProcessPaymentReply reply);

	SagaDto getSagaById(UUID id);
}
