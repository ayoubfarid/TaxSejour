package com.gestionhotel.sejour.dao;

import com.gestionhotel.sejour.bean.Redevable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RedDao  extends JpaRepository <Redevable,Long> {
     public Redevable findByRef(String ref);
     public List<Redevable> findByType(String t);

}
