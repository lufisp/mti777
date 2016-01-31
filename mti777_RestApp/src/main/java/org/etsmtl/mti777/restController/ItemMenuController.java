package org.etsmtl.mti777.restController;

import java.util.List;

import org.etsmtl.mti777.dao.ItemCategoryDao;
import org.etsmtl.mti777.dao.ItemMenuDao;
import org.etsmtl.mti777.model.ItemCategory;
import org.etsmtl.mti777.model.ItemMenu;
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
public class ItemMenuController {
	@Autowired
	ItemMenuDao itemMenuDao;
	ItemCategoryDao iCategoryDao;

	@RequestMapping(path = "/itemMenu/", method = RequestMethod.GET)
	public @ResponseBody List<ItemMenu> list() {
		return itemMenuDao.list();
	}
	
	
	@RequestMapping(path = "/itemMenu/", method = RequestMethod.POST)
	public @ResponseBody ItemMenu create(@RequestBody ItemMenu itemMenu) {		
		return itemMenuDao.create(itemMenu);

	}	

	@RequestMapping(path = "/itemMenu/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		itemMenuDao.delete(Long.valueOf(id));

	}

	@RequestMapping(value = "/itemMenu/", method = RequestMethod.PUT)
	public void update(@RequestBody ItemMenu itemMenu) {
		itemMenuDao.save(itemMenu);
	}

}
