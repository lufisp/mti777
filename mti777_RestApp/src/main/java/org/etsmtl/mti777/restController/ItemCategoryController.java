package org.etsmtl.mti777.restController;

import java.io.IOException;
import java.util.List;

import org.etsmtl.mti777.dao.ItemCategoryDao;
import org.etsmtl.mti777.dao.TableDao;
import org.etsmtl.mti777.model.ItemCategory;
import org.etsmtl.mti777.model.TableRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ItemCategoryController {
	@Autowired
	ItemCategoryDao itemCategoryDao;

	@RequestMapping(path = "/itemCategory/", method = RequestMethod.GET)
	public @ResponseBody List<ItemCategory> list() {
		return itemCategoryDao.list();
	}
	
	/*
	@RequestMapping(path = "/itemCategory/", method = RequestMethod.POST)
	public @ResponseBody ItemCategory create(@RequestBody String jsonString) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(jsonString);
	    JsonNode jsonName = actualObj.get("name");
	    JsonNode jsonId = actualObj.get("id"); 
	    Long id = null;
	    String idString = jsonId.asText();
	    if((idString != null) && (!idString.equals(""))){
	    	id = Long.valueOf(jsonId.asText());
	    }
	    
		return itemCategoryDao.create(jsonName.asText(),id);
	}
	*/
	@RequestMapping(path = "/itemCategory/", method = RequestMethod.POST)
	public @ResponseBody ItemCategory create(@RequestBody ItemCategory itemCat) {		
		return itemCategoryDao.create(itemCat);

	}	

	@RequestMapping(path = "/itemCategory/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		itemCategoryDao.delete(Long.valueOf(id));

	}

	@RequestMapping(value = "/itemCategory/", method = RequestMethod.PUT)
	public void update(@RequestBody ItemCategory itemCategory) {
		itemCategoryDao.save(itemCategory);
	}

}
