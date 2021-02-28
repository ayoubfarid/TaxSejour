package com.gestionhotel.sejour.service;

import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.dao.CateDao;
import org.springframework.beans.factory.annotation.Autowired;


public class CateService {
    @Autowired
    CateDao cateDao;
    public String saveCate(Categorie categorie){
        if(cateDao.countByRef(categorie.getRef())==0){
            cateDao.save(categorie);
            return "la Categorie est save";
        }
        else{
            return "la Categorie est deja existe";
        }
    }

    public Categorie find(String r) {
        return cateDao.findByRef(r);
    }

    public Categorie findByLibelleC(String l) {
        return cateDao.findByLibelle(l);
    }

    public int countByRefC(String ref) {
        return cateDao.countByRef(ref);
    }
}
