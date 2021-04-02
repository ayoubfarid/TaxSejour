package com.gestionhotel.sejour.service;

import java.util.ArrayList;
import java.util.List;

import com.gestionhotel.sejour.bean.Quartier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.dao.LocaleDao;

@Service
public class LocaleService {

	@Autowired
	private LocaleDao localeDao;
	

	public Locale getOne(Long id) {
		return localeDao.getOne(id);
	}

	@Autowired 
	private TaxeSejoureService  taxeSejourService;

	public Locale findAllByRedevableRef(String ref) {
		return localeDao.findAllByRedevableRef(ref);
	}

	public int deleteByRef(String ref) {
		taxeSejourService.deleteByLocaleReference(ref);
		localeDao.deleteByReference(ref);
		return 1 ;
	}
    
	public int deleteByRedevableRef(String ref) {
		return localeDao.deleteByRedevableRef(ref);
	}
    


	public List<Locale> findByRedevable(String refRe) {
		return localeDao.findByRedevableRef(refRe);
	}

	public List<Locale> findByCategorieRef(String refCat) {
		return localeDao.findByCategorieRef(refCat);
	}

	public Locale findByRef(String ref) {
		return localeDao.findByReference(ref);
	}

	public List<Locale> findAll() {
		return localeDao.findAll();
	}
	@Autowired 
	RedevableService redevableservice;
	
	@Autowired 
	CategorieService categorieservice;
	public int save(Locale locale) {
		Locale monlocale = findByRef(locale.getReference());
		Redevable redevable = redevableservice.findByRef(locale.getRedevable().getRef()) ;
		Categorie categorie = categorieservice.findByRef(locale.getCategorie().getRef()) ;
		
		if(monlocale != null) {
			return -1;
		}
		if (redevable != null && categorie != null) {
			locale.setRedevable(redevable);
			locale.setCategorie(categorie);
			localeDao.save(locale);
			return 1;
		}
		else 
			return -2;
		
	}

	public int deleteBySecteurReference(String ref) {
		return 1;
	}

	public List<Quartier> findBySecteurReference(String ref) {
		return new ArrayList<Quartier>();
	}

	public int deleteByReference(String ref) {
		return 1;
	}

	public Locale findByReference(String ref) {
		return new Locale();

	}
}
