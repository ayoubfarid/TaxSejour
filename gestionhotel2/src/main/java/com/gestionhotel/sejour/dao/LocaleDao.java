package com.gestionhotel.sejour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Redevable;

@Repository
public interface LocaleDao extends JpaRepository<Locale,Long>{
	
	public Locale findByRef(String ref);
	public List<Locale> findByRedevable(String redevable);
	public List<Locale> findByCategorieRef(String categorie);
	public Locale findAllByRedevableRef(String ref);
	public int deleteByRef(String ref);
	public int deleteByRedevableRef(String ref);
	
	/*return les locaux appartient au meme rue */
	@Query("SELECT l FROM Locale l WHERE l.rue =: rue")
	public List<Locale> findByRue(@Param("rue") String rue);
	
	/*@Query("select r from Redevable r where r.Redevable.ref=:reference")
	public Redevable findByRedevableQuery(String reference);
	
	@Query("select c from Categorie c where c.Categorie.ref=:reference")
	public Categorie findByCatQuery(String reference);
	
	@Query("select l from Locale l where l.Locale.rue=:rue")
	public Redevable findByRue(@Param("rue") String rue);*/
	
	
}
