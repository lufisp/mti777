
package org.etsmtl.mti777.dao;
import java.util.List;

import org.etsmtl.mti777.model.ItemMenuDet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemMenuDetDao {
	
	@Autowired
	ItemMenuDetRepository iMenuDetRepository;
	
	public ItemMenuDet create(ItemMenuDet itemMenuDet) {
		iMenuDetRepository.save(itemMenuDet);
		return itemMenuDet;
	}	

	public List<ItemMenuDet> list() {
		List<ItemMenuDet> myList = iMenuDetRepository.findAll();
		return myList;
	}

	public void delete(Long id) {
		iMenuDetRepository.delete(id);
	}

	public ItemMenuDet save(ItemMenuDet itemMenuDet) {
		iMenuDetRepository.save(itemMenuDet);
		return itemMenuDet;
	}

	public List<ItemMenuDet> listLastUpdated() {
		List<ItemMenuDet> myList = iMenuDetRepository.listLastUpdated();
		return myList;
	}

}
