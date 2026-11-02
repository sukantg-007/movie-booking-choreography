package org.vedantacomp.saga.client;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.vedantacomp.common.dto.ProcessPaymentCommand;
import org.vedantacomp.common.dto.SagaCompensationCommand;
import org.vedantacomp.common.dto.SeatAllocationCommand;
import org.vedantacomp.common.dto.SeatAllocationReply;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class SagaOrchestratorCommandPublisher {
	
	private final KafkaTemplate<String, Object> kafkaTemplate;
	
	public static final String SEAT_ALLOCATION_COMMAND_TOPIC = "seat-allocation-command-topic";
	public static final String PROCESS_PAYMENT_COMMAND_TOPIC = "process-payment-command-topic";
	public static final String SAGA_COMPENSATION_COMMAND_TOPIC = "saga-compensation-command-topic";
	public static final String SEAT_DEALLOCATION_COMMAND_TOPIC = "seat-deallocation-command-topic";
	
	//1. Publish SEAT ALLOCATION COMMAND to the seat allocation service
	public void publishSeatAllocationCommand(SeatAllocationCommand command) {
		log.info("Publishing seat allocation command to SEAT-ALLOCATION-SERVICE: {}", command);
		kafkaTemplate.send(SEAT_ALLOCATION_COMMAND_TOPIC,command.bookingId().toString(), command);
	}
	//2. Publish PAYMENT COMMAND to the payment service OR
	public void publishProcessPaymentCommand(ProcessPaymentCommand command) {
		log.info("Publishing process payment command to PAYMENT-SERVICE: {}", command);
		kafkaTemplate.send(PROCESS_PAYMENT_COMMAND_TOPIC,command.bookingId().toString(), command);
	}
	//3. Publish SAGA COMPENSATION COMMAND to the booking service in case of 
	//failure OF SEAT ALLOCATION FAILURE OR PAYMENT FAILURE
	public void publishSagaCompensationCommand(SagaCompensationCommand command) {
		log.info("Publishing saga compensation command to BOOKING-SERVICE: {}", command);
		kafkaTemplate.send(SAGA_COMPENSATION_COMMAND_TOPIC,command.bookingId().toString(), command);
	}
	//4. Publish SEAT DEALLOCATION COMMAND to the seat allocation service in case of PAYMENT FAILURE
	public void publishSeatDeallocationCommand(SeatAllocationReply command) {
		log.info("Publishing seat deallocation command to SEAT-ALLOCATION-SERVICE: {}", command);
		kafkaTemplate.send(SEAT_DEALLOCATION_COMMAND_TOPIC,command.bookingId().toString(), command);
	}
	//5. 
	
}
