package com.gestionhotel.sejour.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.dao.QuartierDao;
import com.gestionhotel.sejour.service.facade.QuartierService;
import com.gestionhotel.sejour.service.facade.SecteurService;

@Service
public class QuartierServiceImpl implements QuartierService {

	@Autowired
	private SecteurService secteurService;
	
	@Autowired
	private QuartierDao quartierDao;
	
	
	public Quartier getOne(Long id) {
		return quartierDao.getOne(id);
	}
	public int save(Secteur secteur) {
		return secteurService.save(secteur);
	}
	@Override
	public Quartier findByReference(String reference) {
		return quartierDao.findByReference(reference);
	}
	@Override
	public List<Quartier> findBySecteurReference(String reference) {
		return quartierDao.findBySecteurReference(reference);
	}
	@Override
	@Transactional
	public int deleteByReference(String reference) {
		return quartierDao.deleteByReference(reference);
	}
	@Override
	public int save(Secteur secteur, List<Locale> locales, List<Quartier> quartiers) {
		for(Quartier quartie : quartiers) {
			quartie.setSecteur(secteur);
			quartierDao.save(quartie);
		}
		
		return 1;
	}
	

	

}
