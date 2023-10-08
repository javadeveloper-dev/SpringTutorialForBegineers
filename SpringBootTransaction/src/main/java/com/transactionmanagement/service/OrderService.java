package com.transactionmanagement.service;

import com.transactionmanagement.dto.OrderRequest;
import com.transactionmanagement.dto.OrderrResponse;

public interface OrderService {
	OrderrResponse placeOrder(OrderRequest request);
}
