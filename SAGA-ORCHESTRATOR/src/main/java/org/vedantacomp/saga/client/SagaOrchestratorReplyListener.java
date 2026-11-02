package org.vedantacomp.saga.client;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.vedantacomp.common.dto.BookingCreatedEvent;
import org.vedantacomp.common.dto.ProcessPaymentReply;
import org.vedantacomp.common.dto.SeatAllocationReply;
import org.vedantacomp.saga.service.SagaOrchestratorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class SagaOrchestratorReplyListener {
	
	private final SagaOrchestratorService service;

	//1. Listen to the booking created event from the booking service
	@KafkaListener(topics = "booking-created-topic", groupId = "saga-orchestrator-group")
	public void handleBookingCreatedEvent(BookingCreatedEvent event) {
		log.info("Received booking created event from BOOKING-SERVICE: {} ", event);
		// Handle the booking created event
		service.handleBookingCreatedEvent(event);
	}
	// 2. Listen to seat allocation outcome (success & failure topics)
    @KafkaListener(
        topics = {"seat-allocation-reply-topic", "seat-allocation-failed-reply-topic"},
        groupId = "saga-orchestrator-group",
        containerFactory = "seatAllocationReplyKafkaListenerContainerFactory"
    )
	public void handleSeatAllocationReply(SeatAllocationReply reply) {
		log.info("Received seat allocation reply from SEAT-ALLOCATION-SERVICE: {} ", reply);
		// Handle the seat allocation reply
		service.handleSeatAllocationReply(reply);
	}
 // 3. Listen to payment processing outcome (success & failure topics)
    @KafkaListener(
        topics = {"process-payment-reply-topic", "process-payment-failed-reply-topic"},
        groupId = "saga-orchestrator-group",
        containerFactory = "paymentReplyKafkaListenerContainerFactory"
    )
	public void handleProcessPaymentReply(ProcessPaymentReply reply) {
		log.info("Received process payment reply from PAYMENT-SERVICE: {} ", reply);
		// Handle the process payment reply
		service.handleProcessPaymentReply(reply);
	}
}
