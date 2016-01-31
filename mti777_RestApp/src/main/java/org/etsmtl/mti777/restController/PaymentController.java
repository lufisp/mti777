package org.etsmtl.mti777.restController;

import java.util.List;

import org.etsmtl.mti777.dao.PaymentDao;
import org.etsmtl.mti777.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	@Autowired
	PaymentDao paymentDao;

	@RequestMapping(path = "/payment/", method = RequestMethod.GET)
	public @ResponseBody List<Payment> list() {
		return paymentDao.list();
	}
	
	
	@RequestMapping(path = "/payment/", method = RequestMethod.POST)
	public @ResponseBody Payment create(@RequestBody Payment payment) {		
		return paymentDao.create(payment);

	}	

	@RequestMapping(path = "/payment/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		paymentDao.delete(Long.valueOf(id));

	}

	@RequestMapping(value = "/payment/", method = RequestMethod.PUT)
	public void update(@RequestBody Payment payment) {
		paymentDao.save(payment);
	}

}
