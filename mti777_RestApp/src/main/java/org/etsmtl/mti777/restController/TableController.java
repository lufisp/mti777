package org.etsmtl.mti777.restController;

import java.util.List;

import org.etsmtl.mti777.dao.TableDao;
import org.etsmtl.mti777.model.TableRoom;
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
public class TableController {
	@Autowired
	TableDao tableDao;

	@RequestMapping(path = "/table/", method = RequestMethod.GET)
	public @ResponseBody List<TableRoom> list() {
		return tableDao.list();
	}
	
	@RequestMapping(path = "/table/getTotal/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getTotal(@PathVariable String id) {
		String json = "";
		json += "{\"value\":\"";
		json += tableDao.getTotal(Long.valueOf(id));
		json += "\"}";
		return json;
				
	}

	@RequestMapping(path = "/table/{name}", method = RequestMethod.POST)
	public @ResponseBody TableRoom create(@PathVariable String name) {
		return tableDao.create(name);
	}
	
	
	@RequestMapping(path = "/table/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		tableDao.delete(Long.valueOf(id));

	}

	@RequestMapping(value = "/table/", method = RequestMethod.PUT)
	public void update(@RequestBody TableRoom table) {
		tableDao.save(table);
	}
	
	@RequestMapping(path = "/table/{tableId}", method = RequestMethod.PUT)
	public @ResponseBody TableRoom create(@RequestBody TableRoom table) {
		return tableDao.create(table);
	}

}
