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
    @Autowired
    TypeRedevServ typeRedevServ;
     public String save(Redevable rd){
         if(redevableDao.findByRef(rd.getRef())==null){
             typeRedevServ.save(rd.getType());
             redevableDao.save(rd);
             return "Redevable  seved";
         }
         else
             return   "False Type and ref already exist";
     }
    public Redevable findByRef(String ref) {
        return redevableDao.findByRef(ref);
    }

    public List<Redevable> findByType(String t) {
        return redevableDao.findByType(t);
    }
}
