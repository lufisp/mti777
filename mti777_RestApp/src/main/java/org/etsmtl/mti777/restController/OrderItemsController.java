package org.etsmtl.mti777.restController;

import java.util.List;

import org.etsmtl.mti777.dao.OrderItemsDao;
import org.etsmtl.mti777.model.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderItemsController {
	@Autowired
	OrderItemsDao orderItemsDao;

	@RequestMapping(path = "/orderItems/", method = RequestMethod.GET)
	public @ResponseBody List<OrderItems> list() {
		return orderItemsDao.list();
	}
	
	
	@RequestMapping(path = "/orderItems/", method = RequestMethod.POST)
	public @ResponseBody OrderItems create(@RequestBody OrderItems orderItems) {		
		return orderItemsDao.create(orderItems);

	}	

	@RequestMapping(path = "/orderItems/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		orderItemsDao.delete(Long.valueOf(id));

	}

	@RequestMapping(value = "/orderItems/", method = RequestMethod.PUT)
	public void update(@RequestBody OrderItems orderItems) {
		orderItemsDao.save(orderItems);
	}

}
