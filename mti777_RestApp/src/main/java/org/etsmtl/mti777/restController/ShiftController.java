package org.etsmtl.mti777.restController;

import java.util.List;

import org.etsmtl.mti777.dao.ShiftDao;
import org.etsmtl.mti777.model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiftController {
	@Autowired
	ShiftDao shiftDao;
	
    
    @RequestMapping(path="/shift/",method=RequestMethod.GET)
    public @ResponseBody List<Shift> list(){
    	return shiftDao.list();
    }
    
    @RequestMapping(path="/shift/{name}",method=RequestMethod.POST)
    public @ResponseBody Shift create(@PathVariable String name){    	
    	return shiftDao.create(name);
    	
    }
    
    @RequestMapping(path="/shift/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable String id){
    	shiftDao.delete(Long.valueOf(id));
    	
    }
    
    @RequestMapping(value="/shift/", method=RequestMethod.PUT)
    public void update(@RequestBody Shift pt) {
        shiftDao.save(pt);
    }
    

}
