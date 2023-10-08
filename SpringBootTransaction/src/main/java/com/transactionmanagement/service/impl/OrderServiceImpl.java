package com.transactionmanagement.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transactionmanagement.dto.OrderRequest;
import com.transactionmanagement.dto.OrderrResponse;
import com.transactionmanagement.entity.Order;
import com.transactionmanagement.entity.Payment;
import com.transactionmanagement.exception.PaymentException;
import com.transactionmanagement.repository.OrderRepository;
import com.transactionmanagement.repository.PaymentRepository;
import com.transactionmanagement.service.OrderService;

import jakarta.transaction.Transactional;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
// 	@Transactional
	public OrderrResponse placeOrder(OrderRequest orderRequest) {
		Order order=orderRequest.getOrder();
		order.setStatus("INPROGRESS...");
		order.setOrderTrackingNumber(UUID.randomUUID().toString());
		orderRepository.save(order);
//		Payment payment=orderRequest.getPayment();
//		if(!payment.getType().equals("DEBIT")) {
//			throw new PaymentException("Payment card type do not support ....");
//		}
//		payment.setOrderId(order.getId());
//		paymentRepository.save(payment);
		addPayment(orderRequest,order);
		OrderrResponse orderResponse=new OrderrResponse();
		orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
		orderResponse.setStatus(order.getStatus());
		orderResponse.setMessege("SUCCESS");
		return orderResponse;
	}
	
	@Transactional
	private void addPayment(OrderRequest orderRequest,Order order) {
		Payment payment=orderRequest.getPayment();
		payment.setOrderId(order.getId());
		paymentRepository.save(payment);
	}
}
