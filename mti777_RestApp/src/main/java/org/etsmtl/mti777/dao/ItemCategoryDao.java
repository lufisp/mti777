package org.etsmtl.mti777.dao;

import java.util.List;
import java.util.Optional;

import org.etsmtl.mti777.model.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemCategoryDao {

	
	@Autowired
	ItemCategoryRepository iCatRepository;

	//versão mais complicada...
	public ItemCategory create(String name, Long idRootCategory) {
		Optional<ItemCategory> optRootCategory;
		ItemCategory rootCategory;
		ItemCategory itemCategory = new ItemCategory();
		itemCategory.setName(name);
		if(idRootCategory != null){
			optRootCategory = iCatRepository.findOne(idRootCategory);
			rootCategory = optRootCategory.orElse(null);
			if(rootCategory != null){
				itemCategory.setRootCategory(rootCategory);				
			}
		}		
		iCatRepository.save(itemCategory);
		return itemCategory;
	}
	
	public ItemCategory create(ItemCategory itemCategory) {
		iCatRepository.save(itemCategory.getName(),itemCategory.getRootCategory().getIditemCategory());
		return itemCategory;
	}

	
	

	public List<ItemCategory> list() {
		List<ItemCategory> myList = iCatRepository.findAll();
		return myList;
	}

	public void delete(Long id) {
		iCatRepository.delete(id);
	}

	public ItemCategory save(ItemCategory itemCategory) {
		iCatRepository.save(itemCategory);
		return itemCategory;
	}

	public void update(ItemCategory itemCategory) {
		iCatRepository.update(itemCategory.getName(),itemCategory.getIditemCategory());
		
	}

}
