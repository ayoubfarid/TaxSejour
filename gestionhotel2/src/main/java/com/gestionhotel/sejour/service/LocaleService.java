package com.gestionhotel.sejour.service;

import java.util.ArrayList;
import java.util.List;

import com.gestionhotel.sejour.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	SecteurService secteurrservice;
	@Autowired 
	CategorieService categorieservice;
	public int save(String ref,String red,String ca,String sec , List<TaxeSejour> taxessejour) {
		   Redevable r=redevableservice.findByRef(red);
		   Categorie c=categorieservice.findByRef(ca);
		   Secteur s=secteurrservice.findByReference(sec);
		   Locale locale= new Locale();
		   locale.setCategorie(c);
		   locale.setRedevable(r);
		   locale.setReference(ref);
		   locale.setSecteur(s);
		Locale monlocale = findByRef(locale.getReference());
		Redevable redevable = redevableservice.findByRef(locale.getRedevable().getRef()) ;
		Categorie categorie = categorieservice.findByRef(locale.getCategorie().getRef()) ;

		if(monlocale != null) {
			monlocale.setReference(ref);
			monlocale.setCategorie(c);
			monlocale.setRedevable(r);
			monlocale.setSecteur(s);
			monlocale.setTaxessejour(taxessejour);
			return -1;
		}
		if (redevable != null && categorie != null) {
			locale.setRedevable(redevable);
			locale.setCategorie(categorie);
			localeDao.save(locale);
			if (taxessejour==null) {
				return -4;
			}
			else{
				for (TaxeSejour t:taxessejour){
					t.setLocale(locale);
					taxeSejourService.save(t);
				}
			}
			return 1;
		}
		else{
			return -2;
		}

	}

	public int deleteBySecteurReference(String ref) {
		return 1;
	}

	public List<Quartier> findBySecteurReference(String ref) {
		return new ArrayList<Quartier>();
	}

	public int deleteByReference(String ref) {
		int deleteByLocaleReference= taxeSejourService.deleteByLocaleReference(ref);
		int deleteByref=localeDao.deleteByReference(ref);
		return deleteByref+deleteByLocaleReference;
	}

	public Locale findByReference(String ref) {
		return localeDao.findByReference(ref);

	}


}
