package org.etsmtl.mti777.restController;

import java.util.List;

import org.etsmtl.mti777.dao.OrderClientDao;
import org.etsmtl.mti777.model.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class OrderClientController {
	@Autowired
	OrderClientDao orderClientDao;

	@RequestMapping(path = "/orderClient/", method = RequestMethod.GET)
	public @ResponseBody List<OrderClient> list() {
		return orderClientDao.list();
	}
	
	
	@RequestMapping(path = "/orderClient/", method = RequestMethod.POST)
	public @ResponseBody OrderClient create(@RequestBody OrderClient orderClient) {		
		return orderClientDao.create(orderClient);

	}	

	@RequestMapping(path = "/orderClient/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		orderClientDao.delete(Long.valueOf(id));

	}

	@RequestMapping(value = "/orderClient/", method = RequestMethod.PUT)
	public void update(@RequestBody OrderClient orderClient) {
		orderClientDao.save(orderClient);
	}

}
