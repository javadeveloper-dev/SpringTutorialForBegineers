package com.transactionmanagement.exception;

public class PaymentException extends RuntimeException {
  public PaymentException(String messege) {
	  super(messege);
  }
}
