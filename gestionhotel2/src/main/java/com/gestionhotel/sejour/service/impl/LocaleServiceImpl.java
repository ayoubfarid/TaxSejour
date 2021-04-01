package com.gestionhotel.sejour.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.dao.LocaleDao;
import com.gestionhotel.sejour.service.facade.LocaleService;

@Service
public class LocaleServiceImpl implements LocaleService {

	@Autowired
	private LocaleDao localeDao;

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
	public int deleteBySecteurReference(String ref) {
		return localeDao.deleteBySecteurReference(ref);
	}

	
	@Override
	public List<Quartier> findBySecteurReference(String ref) {
		return localeDao.findBySecteurReference(ref);
	}

	@Override
	public int save(Secteur secteur, List<Locale> locales,List<Quartier> quartiers) {
		for (Locale loc : locales) {
			loc.setSecteur(secteur);
			localeDao.save(loc);
		}
		
		return 1;
	}


	@Override
	public Locale findByReference(String ref) {
		return localeDao.findByReference(ref);
	}


	@Override
	public Locale findAllByRedevableRef(String ref) {
		return localeDao.findAllByRedevableRef(ref);
	}


	@Override
	public List<Locale> findByRedevable(String rfRedevable) {
		return localeDao.findByRedevable(rfRedevable);
	}


	@Override
	public List<Locale> findByCategorieRef(String refcategorie) {
		return localeDao.findByCategorieRef(refcategorie);
	}


	@Override
	public int deleteByRedevableRef(String ref) {
		return localeDao.deleteByRedevableRef(ref);
	}


	@Override
	public int deleteByReference(String ref) {
		return localeDao.deleteByReference(ref);
	}

}
