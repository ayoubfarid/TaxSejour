package com.gestionhotel.sejour.service;

import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.bean.TypeRedevable;
import com.gestionhotel.sejour.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeRedevServ {
    @Autowired
  private TypeDao typeDao;

    public int save(TypeRedevable type){
        if(typeDao.findByNomType(type.getNomType())==null) {
            typeDao.save(type);
            return 1;
        }
        else
            return -1;
    }

    public TypeRedevable findByNomType(String code) {
        return typeDao.findByNomType(code);
    }

    public int countByNomType(String nt) {
        return typeDao.countByNomType(nt);
    }

    public String findByLibelle(String le) {
        return typeDao.findByLibelle(le);
    }

    public TypeRedevable deleteByNomType(String s) {
        return typeDao.deleteByNomType(s);
    }
}
