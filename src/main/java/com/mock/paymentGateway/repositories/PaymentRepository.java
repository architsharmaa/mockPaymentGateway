package com.mock.paymentGateway.repositories;

import com.mock.paymentGateway.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author arsharma
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
