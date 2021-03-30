package com.gestionhotel.sejour.service;

import java.util.ArrayList;
import java.util.List;

import com.gestionhotel.sejour.vo.RedevableTypeVo;
import com.gestionhotel.sejour.vo.RedevableVo;
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
    RedevableTypeService typeRedevServ;
    @Autowired
    TaxeSejoureService taxeSejoureService;
    @Autowired
    LocaleService localeService;

    public List<Redevable> findAll() {
        return redevableDao.findAll();
    }

    public int edit(Redevable redevable) {
        Redevable editredvable = redevableDao.findByRef(redevable.getRef());
        if (editredvable == null) {
            return -1;
        } else {
            editredvable.setRef(redevable.getRef());
            editredvable.setType(typeRedevServ.findByCode(redevable.getType().getCode()));
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
