package com.gestionhotel.sejour.service;

import com.gestionhotel.sejour.bean.TypeRedevable;
import com.gestionhotel.sejour.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeRedevServ {
    @Autowired
  private TypeDao typeDao;
    TypeRedevable pp= new TypeRedevable("personne physique","libil1");
    TypeRedevable pm= new TypeRedevable("personne morale","libil2");
    public int saveType(){
        if (typeDao.countByNomType(pp.getNomType())>1 || typeDao.countByNomType(pm.getNomType())>1){
            return -1;
        }
        else{
            typeDao.save(pm);
            typeDao.save(pp);
            return 1;
        }
    }
    public boolean testType(String s){
        if(s.equals(pm.getNomType())||s.equals(pp.getNomType()))
            return true;
        else
            return false;
    }

    public String findByNomType(String code) {
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
