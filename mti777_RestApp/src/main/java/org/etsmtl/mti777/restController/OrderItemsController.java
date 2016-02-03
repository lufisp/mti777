package org.etsmtl.mti777.restController;

import java.util.List;

import org.etsmtl.mti777.dao.OrderItemsDao;
import org.etsmtl.mti777.model.OrderClient;
import org.etsmtl.mti777.model.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class OrderItemsController {
	@Autowired
	OrderItemsDao orderItemsDao;

	@RequestMapping(path = "/orderItems/", method = RequestMethod.GET)
	public @ResponseBody List<OrderItems> list() {
		return orderItemsDao.list();
	}
	
	@RequestMapping(path = "/orderItems/orderClient/{orderClientId}", method = RequestMethod.GET)
	public @ResponseBody List<OrderItems> listItemsByOrder(@PathVariable String orderClientId) {
		return orderItemsDao.listItemsByOrder(Long.valueOf(orderClientId));
	}
	
	//Exemplo de um controle mais fino com a utilisação de JSON...
	@RequestMapping(path = "/orderItems/orderClientV2/{orderClientId}", 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String listItemsByOrderV2(@PathVariable String orderClientId) {
		String _return = "";
		List<OrderItems> resp =  orderItemsDao.listItemsByOrder(Long.valueOf(orderClientId));
		_return = _return + "[{ \"id\":" + resp.get(0).getIdorderItems() + ",";
		_return = _return + "\"orderClientId\":" + resp.get(0).getOrderClient().getIdOrder() + ",";
		_return = _return + "\"quantity\":" + resp.get(0).getQuantity() + "}]";
		return _return;
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
