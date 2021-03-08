package com.gestionhotel.sejour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Redevable;

@Repository
public interface LocaleDao extends JpaRepository<Locale,Long>{
	
	public Locale findByRef(String ref);
	public int deleteByRef(String ref);
	public int deleteByRedevableRef(String s);
	public List<Locale> findByRedevable(String refRedevable);
	public List<Locale> findByCategorieRef(String refCategorie);
	
	@Query("select r from Redevable r where r.Redevable.ref=:reference")
	public Redevable findByRedevableQuery(String reference);
	
	@Query("select c from Categorie c where c.Categorie.ref=:reference")
	public Categorie findByCatQuery(String reference);
	
	
}
