package com.gestionhotel.sejour.service;

import com.gestionhotel.sejour.bean.RedevableType;
import com.gestionhotel.sejour.dao.RedevableTypeDao;
import com.gestionhotel.sejour.bean.RedevableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RedevableTypeService {
    @Autowired
    private RedevableTypeDao typeDao;

    public int save(RedevableType type) {
        if (typeDao.findByCode(type.getCode()) == null) {
            RedevableType redevableType = new RedevableType();
            redevableType.setCode(type.getCode());
            redevableType.setLibelle(type.getLibelle());
            typeDao.save(redevableType);
            return 1;
        } else
            return -1;
    }

    public int edit(RedevableType type) {
        RedevableType tmpType = typeDao.findByCode(type.getCode());

        if (tmpType == null) {

            return -1;
        } else {
            tmpType.setLibelle(type.getLibelle());
            tmpType.setCode(type.getCode());
            typeDao.save(tmpType);
            return 1;
        }

    }

    public List<RedevableType> findAll() {
        return typeDao.findAll();
    }

    public int findcode(String code) {
        if (typeDao.findByCode(code) != null) {
            return 1;
        } else
            return -1;
    }

    public RedevableType findByCode(String code) {
        return typeDao.findByCode(code);
    }

    @Transactional
    public int deleteByLibelle(String libelle) {
        return typeDao.deleteByLibelle(libelle);
    }
}
