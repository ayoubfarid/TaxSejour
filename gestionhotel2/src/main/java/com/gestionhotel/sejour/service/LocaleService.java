package com.example.projet1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet1.Dao.LocaleDao;
import com.example.projet1.beans.Locale;

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
