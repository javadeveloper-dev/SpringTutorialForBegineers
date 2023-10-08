package com.transactionmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String type;
  private String cardName;
  private String cardNumber;
  private int expiryYear;
  private int expiryMonth;
  private int cvc;
  private Long orderId;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCardName() {
	return cardName;
}
public void setCardName(String cardName) {
	this.cardName = cardName;
}
public String getCardNumber() {
	return cardNumber;
}
public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}
public int getExpiryYear() {
	return expiryYear;
}
public void setExpiryYear(int expiryYear) {
	this.expiryYear = expiryYear;
}
public int getExpiryMonth() {
	return expiryMonth;
}
public void setExpiryMonth(int expiryMonth) {
	this.expiryMonth = expiryMonth;
}
public int getCvc() {
	return cvc;
}
public void setCvc(int cvc) {
	this.cvc = cvc;
}
public Long getOrderId() {
	return orderId;
}
public void setOrderId(Long orderId) {
	this.orderId = orderId;
}
public Payment(Long id, String type, String cardName, String cardNumber, int expiryYear, int expiryMonth, int cvc,
		Long orderId) {
	super();
	this.id = id;
	this.type = type;
	this.cardName = cardName;
	this.cardNumber = cardNumber;
	this.expiryYear = expiryYear;
	this.expiryMonth = expiryMonth;
	this.cvc = cvc;
	this.orderId = orderId;
}
public Payment() {
	super();
}
@Override
public String toString() {
	return "Payment [id=" + id + ", type=" + type + ", cardName=" + cardName + ", cardNumber=" + cardNumber
			+ ", expiryYear=" + expiryYear + ", expiryMonth=" + expiryMonth + ", cvc=" + cvc + ", orderId=" + orderId
			+ "]";
}
  
}
