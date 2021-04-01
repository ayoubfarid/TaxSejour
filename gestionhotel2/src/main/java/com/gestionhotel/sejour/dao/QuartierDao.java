package com.gestionhotel.sejour.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Secteur;

@Repository
public interface QuartierDao extends JpaRepository<Quartier,Long>{
	
	public Quartier findByReference(String reference);
	public List<Quartier> findBySecteurReference(String reference);
	public int deleteByReference(String reference);
	public int save(Secteur secteur,List<Quartier> quartier);
	
	
}
