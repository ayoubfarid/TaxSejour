package com.gestionhotel.sejour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.lang.String;
import com.gestionhotel.sejour.bean.TauTaxeSejour;

@Repository
public interface TauTaxeSejourDao extends JpaRepository<TauTaxeSejour,Long> {

	  List<TauTaxeSejour> findByRefCategorie(String refCategorie);
	//	List<TauTaxeSejour> findByCat(String Cat);
		
		
}
