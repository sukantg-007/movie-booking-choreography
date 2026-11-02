package org.vedantacomp.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vedantacomp.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
