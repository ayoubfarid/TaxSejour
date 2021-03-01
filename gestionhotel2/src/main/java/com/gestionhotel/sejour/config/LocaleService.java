package com.gestionhotel.sejour.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.dao.LocaleDao;

@Service
public class LocaleService {

	@Autowired
	private LocaleDao localeDao;
	
	public List<Locale> findByRefRedevable(String refRe) {
		return localeDao.findByRefRedevable(refRe);
	}

	public List<Locale> findByRefCategorie(String refCat) {
		return localeDao.findByRefCategorie(refCat);
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
