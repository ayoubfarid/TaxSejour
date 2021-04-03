package com.gestionhotel.sejour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Quartier;

@Repository
public interface LocaleDao extends JpaRepository<Locale,Long>{
	
	public int deleteByQuartierReference(String ref);
	public List<Quartier> findByQuartierReference(String ref);
	public Locale findByReference(String ref);
	public Locale findAllByRedevableRef(String ref);
	
	public List<Locale> findByRedevableRef(String redevable);
	public List<Locale> findByCategorieRef(String categorie);
	public int deleteByReference(String ref);
	public int deleteByRedevableRef(String ref);
	
	
	/*@Autowired
	@Query("select r from Redevable r where r.Redevable.ref=:reference")
	public Redevable findByRedevableQuery(String reference);
	
	/*@Query("select c from Categorie c where c.Categorie.ref=:reference")
	public Categorie findByCatQuery(String reference);
	
	@Autowired
	@Query("select l from Locale l where l.Locale.rue=:rue")
	public Redevable findByRue(@Param("rue") String rue);*/
	
	
}
