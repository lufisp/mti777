package org.etsmtl.mti777.restController;

import java.util.List;

import org.etsmtl.mti777.dao.OrderClientDao;
import org.etsmtl.mti777.model.OrderClient;
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
public class OrderClientController {
	@Autowired
	OrderClientDao orderClientDao;

	@RequestMapping(path = "/orderClient/", method = RequestMethod.GET)
	public @ResponseBody List<OrderClient> list() {
		return orderClientDao.list();
	}
	
	@RequestMapping(path = "/orderClient/getTotal/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getTotal(@PathVariable String id) {
		String json = "";
		json += "{\"value\":\"";
		json += orderClientDao.getTotal(Long.valueOf(id));
		json += "\"}";
		return json;				
	}
	
	@RequestMapping(path = "/orderClient/table/{tableId}/shift/{shiftId}", method = RequestMethod.GET)
	public @ResponseBody List<OrderClient> listOrderByTable(@PathVariable String tableId, @PathVariable String shiftId) {
		return orderClientDao.listOrderByTable(Long.valueOf(tableId), Long.valueOf(shiftId));
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
