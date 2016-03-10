package org.etsmtl.mti777.dao;

import java.math.BigDecimal;
import java.util.List;

import org.etsmtl.mti777.model.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends BaseRepository<Payment, Long> {

	@Query("SELECT payment FROM Payment payment WHERE payment.orderClient.idOrder = :orderClient")
	List<Payment> listPaymentByOrderClient(@Param("orderClient") Long orderClient);

	@Query("SELECT sum(payment.total) FROM Payment payment WHERE payment.orderClient.idOrder = :orderClient")
	BigDecimal paymentTotalByOrderClient(@Param("orderClient") Long orderClient);

}
