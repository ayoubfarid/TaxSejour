package com.gestionhotel.sejour.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionhotel.sejour.bean.TaxeSejour;
 @Repository 
public interface  TaxeSejourDao extends JpaRepository<TaxeSejour,Long>{
	
		/* chaque trim de chaque annee on doit payer le montant*/
     public	List<TaxeSejour>  findByLocaleRef(String reference);
   /*un redevable peut avoir plusieurs locaux*/
     public List<TaxeSejour>  findByRedevableRef(String reference);
     public  List<TaxeSejour> findByRedevableRefAndLocaleRef(String refredevable,String reflocale);
     /*faut payer la taxe une fois par trim de chaque annee*/
    public  TaxeSejour findByAnneeAndLocaleRefAndTrimAndRedevableRef(int annee,String locale,int trim,String red);
    int deleteByRedevableRefAndLocaleRef(String red,String loca);
	public  List<TaxeSejour>findAll();
}
