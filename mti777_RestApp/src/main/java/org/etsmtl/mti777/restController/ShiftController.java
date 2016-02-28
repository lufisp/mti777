package org.etsmtl.mti777.restController;

import java.util.List;

import org.etsmtl.mti777.dao.ShiftDao;
import org.etsmtl.mti777.model.Shift;
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
public class ShiftController {
	@Autowired
	ShiftDao shiftDao;
	
    
    @RequestMapping(path="/shift/",method=RequestMethod.GET)
    public @ResponseBody List<Shift> list(){
    	return shiftDao.list();
    }
    
    @RequestMapping(path="/shift/active",method=RequestMethod.GET)
    public @ResponseBody Shift getActive(){
    	return shiftDao.getActive();
    }
    
    @RequestMapping(path="/shift/",method=RequestMethod.POST)
    public @ResponseBody Shift create(@RequestBody Shift shift){    	
    	return shiftDao.create(shift);
    	
    }
    
    @RequestMapping(path="/shift/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable String id){
    	shiftDao.delete(Long.valueOf(id));
    	
    }
    
    @RequestMapping(value="/shift/activate/{id}", method=RequestMethod.PUT)
    public void update(@RequestBody Shift shift) {
        shiftDao.activate(shift.getIdshift());
    }
    
    
    

}
