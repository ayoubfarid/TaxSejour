package com.gestionhotel.sejour.service.facade;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Secteur;

@Service
public interface QuartierService{
	
	public Quartier findByReference(String reference);
	public List<Quartier> findBySecteurReference(String reference);
	public int deleteByReference(String reference);
	public int save(Secteur secteur,List<Quartier> quartier);
	
	
}
