
package org.etsmtl.mti777.restController;
import java.util.List;


import org.etsmtl.mti777.dao.PaymentTypeDao;
import org.etsmtl.mti777.model.PaymentType;
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
public class PaymentTypeRestController {
	@Autowired
	PaymentTypeDao paymentTypeDao;
	
    
    @RequestMapping(path="/paymentType/",method=RequestMethod.GET)
    public @ResponseBody List<PaymentType> list(){
    	return paymentTypeDao.list();
    }
    
    @RequestMapping(path="/paymentType/{name}",method=RequestMethod.POST)
    public @ResponseBody PaymentType create(@PathVariable String name){
    	return paymentTypeDao.create(name);
    	
    }
    
    @RequestMapping(path="/paymentType/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable String id){
    	paymentTypeDao.delete(Long.valueOf(id));
    	
    }
    
    @RequestMapping(value="/paymentType/", method=RequestMethod.PUT)
    public void update(@RequestBody PaymentType pt) {
        paymentTypeDao.save(pt);
    }
    

}
