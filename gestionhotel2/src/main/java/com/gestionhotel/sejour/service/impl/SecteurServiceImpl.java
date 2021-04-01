package com.gestionhotel.sejour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.dao.SecteurDao;
import com.gestionhotel.sejour.service.facade.QuartierService;

@Service
public class SecteurServiceImpl {

	@Autowired
	private SecteurDao secteurDao;
	@Autowired
	private QuartierService quartierService;

	public Secteur findByReference(String ref) {
		return secteurDao.findByReference(ref);
	}

	public int deleteByReference(String ref) {
		int x = quartierService.deleteByReference(ref);
		int y = secteurDao.deleteByReference(ref);
		return x+y;
	}

	public int save(Secteur secteur) {
		Secteur isExit = findByReference(secteur.getReference());
		if(isExit != null) {
			return -1;
		}else {
			secteurDao.save(secteur);
			return 1;
		}
	}

	public Secteur getOne(Long id) {
		return secteurDao.getOne(id);
	}



}
