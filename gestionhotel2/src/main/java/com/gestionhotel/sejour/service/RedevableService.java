package com.gestionhotel.sejour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.bean.RedevableType;
import com.gestionhotel.sejour.dao.RedevableDao;
import com.gestionhotel.sejour.service.facade.LocaleService;

@Service
public class RedevableService {

    @Autowired
    RedevableDao redevableDao;
    @Autowired
    RedevableTypeService typeRedevServ;
    @Autowired
    TaxeSejoureService taxeSejoureService;
    @Autowired
    LocaleService localeService;

    public List<Redevable> findAll() {
        return redevableDao.findAll();
    }

    public int update(Redevable redevable) {
        Redevable editredvable = redevableDao.findByRef(redevable.getRef());
        if (editredvable == null) {
            return -1;
        } else {
            editredvable.setType(typeRedevServ.findByCode(redevable.getType().getCode()));
            redevableDao.save(editredvable);
            return 1;
        }
    }

    public int save(Redevable redevable) {
        RedevableType typeredevable = typeRedevServ.findByCode(redevable.getType().getCode());
        if (redevableDao.findByRef(redevable.getRef()) == null && typeredevable != null) {
            redevableDao.save(redevable);
            return 1;
        } else
            return -1;
    }

    public Redevable findByRef(String ref) {
        return redevableDao.findByRef(ref);
    }
    public int findByReferrence(String ref) {
       if(redevableDao.findByRef(ref)==null){
           return -1;
       }
       else{
           return 1;
       }
    }


    public List<Redevable> findByType(String t) {
        return redevableDao.findByType(t);
    }

    @Transactional
    public int deleteByRef(String ref) {
//        taxeSejoureService.deleteByRedevableRef(ref);
//        localeService.deleteByRedevableRef(ref);
        return redevableDao.deleteByRef(ref);
    }

}
