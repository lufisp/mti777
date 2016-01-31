
package org.etsmtl.mti777.dao;
import java.util.List;

import org.etsmtl.mti777.model.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderItemsDao {
	
	@Autowired
	OrderItemsRepository orderItemsRepository;
	
	public OrderItems create(OrderItems orderItems) {
		orderItemsRepository.save(orderItems);
		return orderItems;
	}	

	public List<OrderItems> list() {
		List<OrderItems> myList = orderItemsRepository.findAll();
		return myList;
	}

	public void delete(Long id) {
		orderItemsRepository.delete(id);
	}

	public OrderItems save(OrderItems orderItems) {
		orderItemsRepository.save(orderItems);
		return orderItems;
	}

}
