package com.gestionhotel.sejour.service.facade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Secteur;

@Service
public interface LocaleService {
	
	public Locale findByReference(String ref);
	public List<Locale> findByRedevable(String redevable);
	public List<Locale> findByCategorieRef(String categorie);
	public Locale findAllByRedevableRef(String ref);
	public int deleteByReference(String ref);
	public int deleteByRedevableRef(String ref);
	public int save(Locale locale,List<Secteur> secteur);
	public int save(Locale locale);
	
}
