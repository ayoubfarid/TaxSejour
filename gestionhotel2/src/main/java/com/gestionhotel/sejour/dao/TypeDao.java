package com.gestionhotel.sejour.dao;

import com.gestionhotel.sejour.bean.TypeRedevable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDao extends JpaRepository<TypeRedevable,Long> {
    public String findByNomType(String code);
    public int countByNomType(String nt);
    public  String findByLibelle(String le);
    public TypeRedevable deleteByNomType(String s);
}
