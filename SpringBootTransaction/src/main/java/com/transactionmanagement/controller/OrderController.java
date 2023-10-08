package com.transactionmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transactionmanagement.dto.OrderRequest;
import com.transactionmanagement.dto.OrderrResponse;
import com.transactionmanagement.service.OrderService;

@RestController
@RequestMapping("/api/v1/order/")
public class OrderController {
	
@Autowired
public OrderService orderService;
	
  @PostMapping("placeOrder")
  public ResponseEntity<OrderrResponse> placeOrder(@RequestBody OrderRequest orderRequest){
	  return ResponseEntity.ok(orderService.placeOrder(orderRequest));
  }

}
