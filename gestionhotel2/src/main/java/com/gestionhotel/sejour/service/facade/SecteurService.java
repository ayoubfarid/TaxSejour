package com.gestionhotel.sejour.service.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Secteur;

public interface SecteurService {
	
	public Secteur findByReference(String ref);
	public int deleteByReference(String ref);
	public int save(Secteur secteur);
	
	
}
