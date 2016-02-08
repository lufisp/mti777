
package org.etsmtl.mti777.dao;
import java.util.List;
import java.util.Optional;

import org.etsmtl.mti777.model.ItemMenuDet;
import org.etsmtl.mti777.model.OrderClient;
import org.etsmtl.mti777.model.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderItemsDao {
	
	@Autowired
	OrderItemsRepository orderItemsRepository;
	@Autowired
	OrderClientRepository orderClientRepository;
	@Autowired
	ItemMenuDetRepository itemMenuDetRepository;
	
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

	public List<OrderItems> listItemsByOrder(Long orderClientId) {
		// TODO Auto-generated method stub
		return orderItemsRepository.listItemsByOrder(orderClientId);
	}

	public OrderItems createItem(String orderClientId, String orderMenuDetId) {
		Optional<OrderClient> orderClient = orderClientRepository.findOne(Long.valueOf(orderClientId));
		Optional<ItemMenuDet> itemMenuDet = itemMenuDetRepository.findOne(Long.valueOf(orderMenuDetId));
		OrderItems orderItem = new OrderItems();
		orderItem.setQuantity(1);
		orderItem.setItemMenuDet(itemMenuDet.get());
		orderItem.setOrderClient(orderClient.get());
		return orderItemsRepository.save(orderItem);
	}

}
