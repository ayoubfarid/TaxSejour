package com.gestionhotel.sejour.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionhotel.sejour.bean.TaxeSejour;
 @Repository 
public interface  TaxeSejourDao extends JpaRepository<TaxeSejour,Long>{
	
		// chaque trim de chaque annee on doit payer le montant
     public	List<TaxeSejour>  findByLocaleRef(String reference);
   //un redevable peut avoir plusieurs locaux
     public List<TaxeSejour>  findByRedvableRef(String reference);
     //un locale a un seul redevable
     public TaxeSejour findByRedevableRefAndLocaleRef(String refredevable,String reflocale);
     //le taxe sejour se calcule une fois par trimestre
    public TaxeSejour findByAnneeAndLocaleRefAndTrimAndRedevableRef(int annee,String locale,int trim,String red);
	public  List<TaxeSejour>findAll();
}
