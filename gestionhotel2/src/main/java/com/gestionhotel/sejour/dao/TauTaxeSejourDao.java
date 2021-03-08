package com.gestionhotel.sejour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestionhotel.sejour.bean.TauTaxeSejour;

@Repository
public interface TauTaxeSejourDao extends JpaRepository<TauTaxeSejour,Long> {

	TauTaxeSejour findByCategorieRef(String ref);
	
	
	TauTaxeSejour findByMontantNuite(double montant);
	
	@Query(" SELECT t FROM TauTaxeSejour t where t.montantNuite >= :montant ")						
	List <TauTaxeSejour> findByMontantNuiteSuperieur(@Param("montant") double montant);
	
	
		
		
}
