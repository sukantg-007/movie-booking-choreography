package org.vedantacomp.common.dto;

import lombok.Builder;

@Builder
public record PaymentResult(
		boolean success,
		String message
		) {

}
