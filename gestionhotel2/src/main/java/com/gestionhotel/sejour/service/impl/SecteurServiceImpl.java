package com.gestionhotel.sejour.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.dao.SecteurDao;
import com.gestionhotel.sejour.service.facade.LocaleService;
import com.gestionhotel.sejour.service.facade.QuartierService;
import com.gestionhotel.sejour.service.facade.SecteurService;

@Service
public class SecteurServiceImpl implements SecteurService {

	@Autowired
	private SecteurDao secteurDao;
	@Autowired
	private QuartierService quartierService;
	@Autowired
	private LocaleService localeService;

	@Override
	public Secteur findByReference(String ref) {
		return secteurDao.findByReference(ref);
	}

	@Override
	@Transactional
	public int deleteByReference(String ref) {
		int x = quartierService.deleteByReference(ref);
		int y = secteurDao.deleteByReference(ref);
		int z = secteurDao.deleteByReference(ref);
		return x+y+z;
	}

	@Override
	public int save(Secteur secteur) {
		Secteur isExit = findByReference(secteur.getReference());
		if(isExit != null) {
			return -1;
		}else {
			secteurDao.save(secteur);
			localeService.save(secteur, secteur.getLocales(),secteur.getQuatriers());
			return 1;
		}
	}
	
	



}
