package org.etsmtl.mti777.restController;

import java.util.List;

import org.etsmtl.mti777.dao.ItemCategoryDao;
import org.etsmtl.mti777.dao.ItemMenuDetDao;
import org.etsmtl.mti777.model.ItemCategory;
import org.etsmtl.mti777.model.ItemMenu;
import org.etsmtl.mti777.model.ItemMenuDet;
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
public class ItemMenuDetController {
	@Autowired
	ItemMenuDetDao itemMenuDetDao;

	@RequestMapping(path = "/itemMenuDet/", method = RequestMethod.GET)
	public @ResponseBody List<ItemMenuDet> list() {
		return itemMenuDetDao.list();
	}
	
	@RequestMapping(path = "/itemMenuDet/lastUpdated", method = RequestMethod.GET)
	public @ResponseBody List<ItemMenuDet> listLastUpdated() {
		return itemMenuDetDao.listLastUpdated();
	}
	
	
	@RequestMapping(path = "/itemMenuDet/", method = RequestMethod.POST)
	public @ResponseBody ItemMenuDet create(@RequestBody ItemMenuDet itemMenuDet) {		
		return itemMenuDetDao.create(itemMenuDet);

	}	

	@RequestMapping(path = "/itemMenuDet/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		itemMenuDetDao.delete(Long.valueOf(id));

	}

	@RequestMapping(value = "/itemMenuDet/", method = RequestMethod.PUT)
	public void update(@RequestBody ItemMenuDet itemMenuDet) {
		itemMenuDetDao.save(itemMenuDet);
	}

}
