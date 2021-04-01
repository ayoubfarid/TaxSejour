package com.gestionhotel.sejour.service.facade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Secteur;

public interface LocaleService {

	public Locale findAllByRedevableRef(String ref);
	public List<Locale> findByRedevable(String redevable);
	public List<Locale> findByCategorieRef(String categorie);
	public int deleteByRedevableRef(String ref);
	public int deleteByReference(String ref);
	public int deleteBySecteurReference(String ref);
	public List<Quartier> findBySecteurReference(String ref);
	public Locale findByReference(String ref);
	
	public int save(Secteur secteur,List<Locale> locales,List<Quartier> quartiers);
}
