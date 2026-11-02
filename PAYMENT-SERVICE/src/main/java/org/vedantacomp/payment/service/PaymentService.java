package org.vedantacomp.payment.service;

import java.util.List;

import org.vedantacomp.common.dto.PaymentDto;

public interface PaymentService {

    void createPayment(PaymentDto paymentDto);

    PaymentDto getPaymentById(Long id);
    
    List<PaymentDto> getAllPayments();
}
