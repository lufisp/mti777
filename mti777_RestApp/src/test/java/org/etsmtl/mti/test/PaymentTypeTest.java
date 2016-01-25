package org.etsmtl.mti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.etsmtl.mti777.dao.PaymentTypeDao;
import org.etsmtl.mti777.model.PaymentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SampleDataJpaApplication.class)
public class PaymentTypeTest {
	
	@Autowired
	PaymentTypeDao pDao;

	@Test
	public void testFindAll() throws Exception {
		PaymentType pt = pDao.create("cartao");
		pt = pDao.create("cartao2");
		
		List<PaymentType> listPayment= pDao.list();
		System.out.println(listPayment);
		
		assertEquals("A","A");
	}
	
}


