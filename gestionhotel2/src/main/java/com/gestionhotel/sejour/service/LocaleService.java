package com.gestionhotel.sejour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.dao.LocaleDao;

@Service
public class LocaleService {

	@Autowired
	private LocaleDao localeDao;
	

	public Locale deleteByRef(String ref) {
		return localeDao.deleteByRef(ref);
	}

	
	public Locale findByRedevable(String refRe) {
		return localeDao.findByRedevable(refRe);
	}

	public Locale findByCategorie(String refCat) {
		return localeDao.findByCategorie(refCat);
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
