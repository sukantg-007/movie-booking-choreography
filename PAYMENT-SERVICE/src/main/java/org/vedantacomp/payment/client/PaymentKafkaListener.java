package org.vedantacomp.payment.client;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.vedantacomp.common.dto.PaymentDto;
import org.vedantacomp.common.dto.PaymentStatus;
import org.vedantacomp.common.dto.ProcessPaymentCommand;
import org.vedantacomp.payment.service.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class PaymentKafkaListener {

	private final PaymentService paymentService;
	
	// 1. Listen to the process payment command topic for Saga orchestration commands
	@KafkaListener(topics = "process-payment-command-topic", groupId = "payment-service-group")
	public void handleProcessPaymentCommand(ProcessPaymentCommand command) {
		log.info("Received process payment command: {}", command);
		PaymentDto paymentDto = PaymentDto.builder()
				.sagaId(command.sagaId())
				.bookingId(command.bookingId())
				.amount(command.amount())
				.status(null) // Assuming the status is set to PROCESSED upon creation
				.transactionId(null) // Assuming the transactionId is generated upon processing
				.status(PaymentStatus.UNDER_PROCESSING)
				.build();
		paymentService.createPayment(paymentDto);
	}
}
