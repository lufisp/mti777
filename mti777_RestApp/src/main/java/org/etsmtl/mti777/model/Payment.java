package org.etsmtl.mti777.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue
	private Long idpayment;

	@ManyToOne
	@JoinColumn(name = "paymentType")
	private PaymentType paymentType;

	@ManyToOne
	@JoinColumn(name = "idOrderClient")
	private OrderClient orderClient;
	
	@Column(precision=5, scale=2)
	private BigDecimal total;

	public Long getIdpayment() {
		return idpayment;
	}

	public void setIdpayment(Long idpayment) {
		this.idpayment = idpayment;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public OrderClient getOrderClient() {
		return orderClient;
	}

	public void setOrderClient(OrderClient orderClient) {
		this.orderClient = orderClient;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
}
