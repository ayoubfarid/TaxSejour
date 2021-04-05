package com.gestionhotel.sejour.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestionhotel.sejour.bean.TaxeSejour;
 @Repository 
public interface  TaxeSejourDao extends JpaRepository<TaxeSejour,Long>{
     public	List<TaxeSejour>  findByLocaleReference(String reference);
     public List<TaxeSejour>  findByRedevableRef(String reference);
     public  List<TaxeSejour> findByRedevableRefAndLocaleReference(String refredevable,String reflocale);
    public  TaxeSejour findByAnneeAndLocaleReferenceAndTrimAndRedevableRef(int annee,String locale,int trim,String red);
    int deleteByRedevableRefAndLocaleReference(String red,String loca);
	public int deleteByRedevableRef(String s);
	public int deleteByLocaleReference(String s);
	@Query("SELECT t from TaxeSejour t where t.annee=:an")// 
	List<TaxeSejour> findByAnneespecifique(@Param("an") int an);
}
