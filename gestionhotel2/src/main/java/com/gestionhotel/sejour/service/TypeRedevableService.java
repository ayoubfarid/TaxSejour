package com.gestionhotel.sejour.service;

import com.gestionhotel.sejour.bean.RedevableType;
import com.gestionhotel.sejour.dao.RedevableTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeRedevableService {
    @Autowired
  private RedevableTypeDao typeDao;

    public int save(RedevableType type){
        if(typeDao.findByCode(type.getCode())==null) {
            typeDao.save(type);
            return 1;
        }
        else
            return -1;
    }

    public RedevableType findByNomType(String code) {
        return typeDao.findByCode(code);
    }

    public String findByLibelle(String le) {
        return typeDao.findByLibelle(le);
    }

}
