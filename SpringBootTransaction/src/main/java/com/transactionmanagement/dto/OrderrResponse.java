package com.transactionmanagement.dto;

public class OrderrResponse {
   private String orderTrackingNumber;
   private String status;
   private String messege;
public String getOrderTrackingNumber() {
	return orderTrackingNumber;
}
public void setOrderTrackingNumber(String orderTrackingNumber) {
	this.orderTrackingNumber = orderTrackingNumber;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getMessege() {
	return messege;
}
public void setMessege(String messege) {
	this.messege = messege;
}
   
}
