package com.gestionhotel.sejour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.dao.LocaleDao;

@Service
public class LocaleService {

	@Autowired
	private LocaleDao localeDao;
	

	@Autowired 
	private TaxeSejoureService  taxeSejourService;
	public int deleteByRef(String ref) {
		taxeSejourService.deleteByLocaleRef(ref);
		localeDao.deleteByRef(ref);
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

	public Locale findByRef(String ref) {
		return localeDao.findByRef(ref);
	}

	public List<Locale> findAll() {
		return localeDao.findAll();
	}

	public int save(Locale locale) {
		Locale monlocale = findByRef(locale.getRef());
		if(monlocale != null) {
			return -1;
		}
		else{
			localeDao.save(locale);
			return 1;
		}
	}
}
