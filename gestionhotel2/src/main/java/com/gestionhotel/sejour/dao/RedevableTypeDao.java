package com.gestionhotel.sejour.dao;

import com.gestionhotel.sejour.bean.RedevableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedevableTypeDao extends JpaRepository<RedevableType,Long> {
    List<RedevableType> findAll();
    RedevableType findByCode(String code);
    RedevableType findByLibelle(String libelle);
    int deleteByLibelle(String libelle);
}
