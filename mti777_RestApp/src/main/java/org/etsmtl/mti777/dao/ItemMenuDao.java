
package org.etsmtl.mti777.dao;
import java.util.List;

import org.etsmtl.mti777.model.ItemMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemMenuDao {

	
	@Autowired
	ItemMenuRepository iMenuRepository;
	
	public ItemMenu create(ItemMenu itemMenu) {
		iMenuRepository.save(itemMenu);
		return itemMenu;
	}	

	public List<ItemMenu> list() {
		List<ItemMenu> myList = iMenuRepository.findAll();
		return myList;
	}

	public void delete(Long id) {
		iMenuRepository.delete(id);
	}

	public ItemMenu save(ItemMenu itemMenu) {
		iMenuRepository.save(itemMenu);
		return itemMenu;
	}

}
