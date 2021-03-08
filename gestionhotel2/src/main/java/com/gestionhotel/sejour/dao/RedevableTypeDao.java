package com.gestionhotel.sejour.dao;

import com.gestionhotel.sejour.bean.RedevableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedevableTypeDao extends JpaRepository<RedevableType,Long> {
     RedevableType findByCode(String code);
      String findByLibelle(String le);
}
