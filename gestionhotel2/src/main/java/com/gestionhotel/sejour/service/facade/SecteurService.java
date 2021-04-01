package com.gestionhotel.sejour.service.facade;

import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Secteur;

@Service
public interface SecteurService {
	
	public Secteur findByReference(String ref);
	public int deleteByReference(String ref);
	public int save(Secteur secteur);
	
	
}
