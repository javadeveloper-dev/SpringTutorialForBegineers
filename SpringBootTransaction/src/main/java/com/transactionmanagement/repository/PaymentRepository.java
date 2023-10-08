package com.transactionmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transactionmanagement.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>  {
	public Payment save(Payment payment);

}
