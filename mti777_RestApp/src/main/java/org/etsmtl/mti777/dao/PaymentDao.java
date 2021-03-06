
package org.etsmtl.mti777.dao;
import java.math.BigDecimal;
import java.util.List;

import org.etsmtl.mti777.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentDao {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	public Payment create(Payment payment) {
		paymentRepository.save(payment);
		return payment;
	}	

	public List<Payment> list() {
		List<Payment> myList = paymentRepository.findAll();
		return myList;
	}

	public void delete(Long id) {
		paymentRepository.delete(id);
	}

	public Payment save(Payment payment) {
		paymentRepository.save(payment);
		return payment;
	}

	public List<Payment> listPaymentByOrderClient(Long orderId) {
		return paymentRepository.listPaymentByOrderClient(orderId);
	}

	public BigDecimal paymentTotaltByOrderClient(Long orderId) {
		return paymentRepository.paymentTotalByOrderClient(orderId);
	}

}
