package com.gestionhotel.sejour.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.dao.LocaleDao;
import com.gestionhotel.sejour.service.CategorieService;
import com.gestionhotel.sejour.service.RedevableService;
import com.gestionhotel.sejour.service.TaxeSejoureService;

@Service
public class LocaleServiceImpl {

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

	public int deleteByReference(String ref) {
		taxeSejourService.deleteByLocaleRef(ref);
		localeDao.deleteByReference(ref);
		return 1 ;
	}
    
	public int deleteByRedevableRef(String ref) {
		return localeDao.deleteByRedevableRef(ref);
	}
    


	public List<Locale> findByRedevable(String refRe) {
		return localeDao.findByRedevable(refRe);
	}

	public List<Locale> findByCategorieRef(String refCat) {
		return localeDao.findByCategorieRef(refCat);
	}

	public Locale findByReference(String ref) {
		return localeDao.findByReference(ref);
	}

	public List<Locale> findAll() {
		return localeDao.findAll();
	}
	@Autowired 
	RedevableService redevableservice;
	
	@Autowired 
	CategorieService categorieservice;
	public int save(Locale locale,List<Secteur> secteur) {
		Locale monlocale = findByReference(locale.getReference());
		Redevable redevable = redevableservice.findByRef(locale.getRedevable().getRef()) ;
		Categorie categorie = categorieservice.find(locale.getCategorie().getRef()) ;;
		
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
}
