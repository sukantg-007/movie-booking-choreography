package org.vedantacomp.saga.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vedantacomp.common.dto.SagaDto;
import org.vedantacomp.saga.service.SagaOrchestratorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/saga")
public class SagaController {

	private final SagaOrchestratorService sagaOrchestratorService;
	
	@GetMapping("/booking/{bookingId}")
	public ResponseEntity<SagaDto> getSagaStatus(@PathVariable Long bookingId) {
		log.info("Fetching saga status for bookingId: {}", bookingId);
		SagaDto sagaStatus = sagaOrchestratorService.getSagaByBookingId(bookingId);
		return ResponseEntity.ok(sagaStatus);
	}
}
