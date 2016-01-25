package org.etsmtl.mti777.dao;

import java.util.List;

import org.etsmtl.mti777.model.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;

@Service
@Transactional
public class PaymentTypeDao {

	@Autowired
	PaymentTypeRepository paymentTypeRepository;

	public PaymentType create(String name) {
		PaymentType pt = new PaymentType();
		pt.setName(name);
		paymentTypeRepository.save(pt);
		return pt;

	}

	public List<PaymentType> list() {
		List<PaymentType> myList = paymentTypeRepository.findAll();
		return myList;
	}
	
	public void delete(Long id) {
		paymentTypeRepository.delete(id);
	}
	
	public PaymentType save(PaymentType pt){
		paymentTypeRepository.save(pt);
		return pt;
	}

}
