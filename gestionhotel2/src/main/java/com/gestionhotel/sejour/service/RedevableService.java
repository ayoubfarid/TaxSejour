package com.gestionhotel.sejour.service;

import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.dao.RedevableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
     public int save(Redevable rd){
         if(redevableDao.findByRef(rd.getRef())==null){
             typeRedevServ.save(rd.getType());
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
