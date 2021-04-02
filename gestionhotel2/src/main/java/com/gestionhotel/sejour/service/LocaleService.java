package com.gestionhotel.sejour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.dao.LocaleDao;
import com.gestionhotel.sejour.vo.LocaleServiceVo;

@Service
public class LocaleService implements LocaleServiceVo {

	@Autowired
	private LocaleDao localeDao;

	public int deleteBySecteurReference(String ref) {
		return localeDao.deleteBySecteurReference(ref);
	}

	public List<Quartier> findBySecteurReference(String ref) {
		return localeDao.findBySecteurReference(ref);
	}

	public Locale findByReference(String ref) {
		return localeDao.findByReference(ref);
	}

	public List<Locale> findByRedevable(String redevable) {
		return localeDao.findByRedevableRef(redevable);
	}

	public List<Locale> findByCategorieRef(String categorie) {
		return localeDao.findByCategorieRef(categorie);
	}

	public int deleteByReference(String ref) {
		return localeDao.deleteByReference(ref);
	}

	public int deleteByRedevableRef(String ref) {
		return localeDao.deleteByRedevableRef(ref);
	}

	public int save(Locale locale) {
		Locale  loc = findByReference(locale.getReference());
		if(loc != null) {
			return -1;
		}
		else {
			localeDao.save(locale);
			return 1;
		}
	}

	public List<Locale> findAll() {
		return localeDao.findAll();
	}

	public Locale getOne(Long id) {
		return localeDao.getOne(id);
	}

	@Override
	public int save(Secteur secteur, List<Locale> locales) {
		for (Locale loc : locales) {
			loc.setSecteur(secteur);
			localeDao.save(loc);
		}
		
		return 1;
	}



	

}
