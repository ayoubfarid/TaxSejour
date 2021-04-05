package com.gestionhotel.sejour.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.dao.QuartierDao;
import com.gestionhotel.sejour.dao.SecteurDao;
import com.gestionhotel.sejour.vo.QuartierServiceVo;
import com.gestionhotel.sejour.vo.SecteurServiceVo;

@Service
public class SecteurService implements SecteurServiceVo {


 @Autowired
	private SecteurDao secteurDao;
	@Autowired
	private QuartierService quartierService;

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
	    //List<Quartier> quartiers = quartierService.findBySecteurReference(secteur.getReference());
		if(isExit != null) {
			return -1;
		}else {
			List<Quartier> quart = secteur.getQuatriers();
			secteurDao.save(secteur);
			quartierService.save(secteur , quart);
			return 1;
		}
	}
	
	

	

	
	

	
	

}
