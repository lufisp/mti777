
package org.etsmtl.mti777.dao;
import java.util.List;

import org.etsmtl.mti777.model.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderClientDao {
	
	@Autowired
	OrderClientRepository orderClientRepository;
	
	public OrderClient create(OrderClient OrderClient) {
		orderClientRepository.save(OrderClient);
		return OrderClient;
	}	

	public List<OrderClient> list() {
		List<OrderClient> myList = orderClientRepository.findAll();
		return myList;
	}

	public void delete(Long id) {
		orderClientRepository.delete(id);
	}

	public OrderClient save(OrderClient OrderClient) {
		orderClientRepository.save(OrderClient);
		return OrderClient;
	}

	public List<OrderClient> listOrderByTable(Long tableId, Long shiftId) {
		List<OrderClient> myList = orderClientRepository.listOrderByTable(tableId, shiftId);
		return myList;
	}

	public String getTotal(Long id) {
		return orderClientRepository.getTotal(id);
	}

}
