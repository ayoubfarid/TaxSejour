package com.gestionhotel.sejour.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.bean.TauTaxeSejour;

@Repository
public interface TauTaxeSejourDao extends JpaRepository<TauTaxeSejour,Long> {

	 Categorie findByCategorieRef(String ref);
	//	List<TauTaxeSejour> findByCat(String Cat);
		
		
}
