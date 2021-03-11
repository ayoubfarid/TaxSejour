package com.gestionhotel.sejour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.bean.RedevableType;
import com.gestionhotel.sejour.dao.RedevableDao;

@Service
public class RedevableService {

    @Autowired
    RedevableDao redevableDao;
    
	@Autowired
    TypeRedevableService typeRedevServ;
    @Autowired
    TaxeSejoureService taxeSejoureService;
    @Autowired
    LocaleService localeService;
    
    RedevableType typeredevable;
    
    public List<Redevable> findAll() {
		return redevableDao.findAll();
	}
    
     public int save(Redevable rd){
    	 
    	 typeredevable =typeRedevServ.findByCode( rd.getType().getCode());
         if(redevableDao.findByRef(rd.getRef())==null && typeredevable!=null ){
        	 
             rd.setType(typeredevable);
             redevableDao.save(rd);
             return 1;
         }
         else
             return  -1;
     }
    public Redevable findByRef(String ref) {
        return redevableDao.findByRef(ref);
    }
    public List<Redevable> findByType(String t) {
        return redevableDao.findByType(t);
    }
    @Transactional
    public int deleteByRef(String ref) {
         taxeSejoureService.deleteByRedevableRef(ref);
         localeService.deleteByRedevableRef(ref);
         if (taxeSejoureService.findByRedevableRef(ref)==null&&localeService.findAllByRedevableRef(ref)==null)
        return redevableDao.deleteByRef(ref);
         else
             return -1;
    }

}
