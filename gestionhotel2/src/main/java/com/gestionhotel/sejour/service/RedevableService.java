package com.gestionhotel.sejour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.bean.TaxeSejour;
import com.gestionhotel.sejour.dao.RedevableDao;

@Service
public class RedevableService {
    @Autowired
    RedevableDao redevableDao;
    LocaleService localeService;
    TypeRedevServ typeRedevServ;
    @Autowired
    TaxeSejoureService taxesejour;
    LocaleService localeService2;

     public String SaveRed(Redevable rd){
         if(redevableDao.countByRef(rd.getRef())==0 &&typeRedevServ.testType(rd.getType().getNomType())){
             redevableDao.save(rd);
             return "Redevable  seved";
         }
         else if (!typeRedevServ.testType(rd.getType().getNomType())){
             return "False Type";
         }
         else if(redevableDao.countByRef(rd.getRef())>0)
             return "ref already exist";
         else
             return  "False Type and ref already exist";
     }
     public List <Locale> allLocaleOfRdv(String ref){
         return localeService.findByRedevable(ref);
     }
    public Redevable findByRef(String ref) {
        return redevableDao.findByRef(ref);
    }

    public List<Redevable> findByType(String t) {
        return redevableDao.findByType(t);
    }
    public List<TaxeSejour>  listTaxOfRed(String ref){
    	return taxesejour.findByRedevableRef(ref);
    	
    }
    public int deleteRed(String ref){
    	taxesejour.deleteByRedevableRef(ref);
    	localeService.deleteByRedevableRef(ref);
    	redevableDao.deleteByRef(ref);
    	return  1;
    }
}
