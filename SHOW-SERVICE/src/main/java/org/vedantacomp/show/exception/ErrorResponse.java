package org.vedantacomp.show.exception;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record ErrorResponse(
		int status,
		String message,
		String error,
		String path,
		LocalDateTime timestamp
		
		) {

}
