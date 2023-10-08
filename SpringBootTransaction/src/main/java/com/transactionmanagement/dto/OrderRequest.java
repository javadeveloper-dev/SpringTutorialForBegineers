package com.transactionmanagement.dto;

import com.transactionmanagement.entity.Order;
import com.transactionmanagement.entity.Payment;

public class OrderRequest {
    private Order order;
    private Payment payment;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
    
    
}	
