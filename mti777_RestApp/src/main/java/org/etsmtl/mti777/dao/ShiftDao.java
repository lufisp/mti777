package org.etsmtl.mti777.dao;

import java.util.List;

import org.etsmtl.mti777.model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShiftDao{
	
	@Autowired
	ShiftRepository shiftRepository;

	public Shift create(Shift shift) {
		shiftRepository.save(shift);
		return shift;

	}

	public List<Shift> list() {
		List<Shift> myList = shiftRepository.findAll();
		return myList;
	}
	
	public void delete(Long id) {
		shiftRepository.delete(id);
	}
	
	public Shift save(Shift shift){
		shiftRepository.save(shift);
		return shift;
	}

	public void activate(Long shiftId) {
		shiftRepository.desactivateAll();
		shiftRepository.activate(shiftId);
		
	}

	public Shift getActive() {
		return shiftRepository.getActive();
	}

	
}
