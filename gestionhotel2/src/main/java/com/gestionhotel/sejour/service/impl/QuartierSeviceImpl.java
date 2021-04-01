package com.gestionhotel.sejour.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.dao.QuartierDao;
import com.gestionhotel.sejour.service.facade.SecteurService;

@Service
public class QuartierSeviceImpl {

	@Autowired
	private SecteurService secteurService;
	@Autowired
	private QuartierDao quartiesDao;
	

	public int deleteByReference(String ref) {
		quartiesDao.deleteByReference(ref);
		return 1 ;
	}
    
	public List<Quartier> findBySecteurReference(String reference) {
		return quartiesDao.findBySecteurReference(reference);
	}

	public Quartier findByReference(String ref) {
		return quartiesDao.findByReference(ref);
	}

	public int save(Quartier quartier) {
		Quartier isExitquarties = findByReference(quartier.getReference());
		
		if(isExitquarties != null) {
			return -1;
		}
		else  {
			quartiesDao.save(quartier);
			return 1;
		}
		
	}
}
