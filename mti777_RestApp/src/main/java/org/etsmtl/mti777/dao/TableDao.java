package org.etsmtl.mti777.dao;

import java.util.List;

import org.etsmtl.mti777.model.TableRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TableDao {

	
	@Autowired
	TableRepository tableRepository;

	public TableRoom create(String name) {
		TableRoom table = new TableRoom();
		table.setName(name);
		table.setAvailableFlag(false);
		tableRepository.save(table);
		return table;

	}

	public List<TableRoom> list() {
		List<TableRoom> myList = tableRepository.findAll();
		return myList;
	}

	public void delete(Long id) {
		tableRepository.delete(id);
	}

	public TableRoom save(TableRoom table) {
		tableRepository.save(table);
		return table;
	}

}
