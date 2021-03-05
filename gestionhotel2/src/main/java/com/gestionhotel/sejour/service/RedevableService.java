package com.gestionhotel.sejour.service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.dao.RedevableDao;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedevableService {
    @Autowired
    RedevableDao redevableDao;
    LocaleService localeService;
     public int SaveRed(Redevable rd){
         if(redevableDao.countByRef(rd.getRef())>0){
             return -1;
         }
         else{
             redevableDao.save(rd);
          return  1;
         }
     }
     public List <Locale> allLocoleOfRdv(String ref){
         return localeService.findByRedevable(ref);
     }
    public Redevable findByRef(String ref) {
        return redevableDao.findByRef(ref);
    }

    public List<Redevable> findByType(String t) {
        return redevableDao.findByType(t);
    }
}
