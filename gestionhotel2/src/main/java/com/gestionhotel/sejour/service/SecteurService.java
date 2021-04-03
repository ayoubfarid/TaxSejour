package com.gestionhotel.sejour.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.dao.SecteurDao;
import com.gestionhotel.sejour.vo.SecteurServiceVo;

@Service
public class SecteurService implements SecteurServiceVo {
	
	@Autowired
	private SecteurDao secteurDao;

	@Override
	public Secteur findByReference(String ref) {
		return secteurDao.findByReference(ref);
	}

	@Override
	@Transactional
	public int deleteByReference(String ref) {
		int x = quartierService.deleteBySecteurReference(ref);
		int y = secteurDao.deleteByReference(ref);
		return x+y;
	}

	@Override
	public int save(Secteur secteur) {
		Secteur isExit = findByReference(secteur.getReference());
		if(isExit != null) {
			return -1;
		}else {
			secteurDao.save(secteur);
			quartierService.save(secteur, secteur.getQuatriers());
			return 1;
		}
	}
	
	

	@Autowired
	private QuartierService quartierService;

	
	

	
	

}
