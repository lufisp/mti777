package org.etsmtl.mti777.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paymentType")
public class PaymentType {
	
	@Id
	@GeneratedValue
	private Long idpaymentType;
	
	private String name;

	public Long getIdpaymentType() {
		return idpaymentType;
	}

	public void setIdpaymentType(Long idpaymentType) {
		this.idpaymentType = idpaymentType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: " + idpaymentType + ",name:" + name ;
	}
	
	
	

}
