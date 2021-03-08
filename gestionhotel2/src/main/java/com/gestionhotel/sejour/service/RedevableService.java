package com.gestionhotel.sejour.service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.dao.RedevableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;

@Service
public class RedevableService {
    @Autowired
    RedevableDao redevableDao;
    TypeRedevServ typeRedevServ;
    CategorieService categorieService;

     public String SaveRed(Redevable rd){
         if(redevableDao.countByRef(rd.getRef())==0&&typeRedevServ.testType(rd.getType().getNomType())){
             typeRedevServ.savredh(rd);
             redevableDao.save(rd);
             return "Redevable  seved";
         }
         else if (!typeRedevServ.testType(rd.getType().getNomType())){
             return "False Type";
         }
         else if(redevableDao.countByRef(rd.getRef())>0)
             return "ref already exist";
         else
             return   "False Type and ref already exist";
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
    TaxeSejoureService taxeSejoureService;
     LocaleService localeService;
    public Hashtable deleteRed(String ref){
         //taxesegour.
        taxeSejoureService.deleteByRedevableRef(ref);
        //local.
        localeService.deleteByRedevableRef(ref);
        //red.
        redevableDao.deleteByRef(ref);
         Hashtable a =new Hashtable();
         a.put("Redevable de ref"+ref+" was deleted",redevableDao.findByRef(ref));
        return a ;
    }
}
