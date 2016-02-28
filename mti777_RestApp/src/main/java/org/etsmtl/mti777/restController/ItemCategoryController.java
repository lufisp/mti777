package org.etsmtl.mti777.restController;

import java.util.List;

import org.etsmtl.mti777.auxiliary.TreeNode;
import org.etsmtl.mti777.dao.ItemCategoryDao;
import org.etsmtl.mti777.model.ItemCategory;
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
public class ItemCategoryController {
	@Autowired
	ItemCategoryDao itemCategoryDao;

	@RequestMapping(path = "/itemCategory/", method = RequestMethod.GET)
	public @ResponseBody List<ItemCategory> list() {
		return itemCategoryDao.list();
	}
	
	
	@RequestMapping(path = "/itemCategory/getTreeJson/", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String  getTree() {
		List<ItemCategory> listCat = itemCategoryDao.list();
		return TreeNode.getTreeJson(listCat);
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
