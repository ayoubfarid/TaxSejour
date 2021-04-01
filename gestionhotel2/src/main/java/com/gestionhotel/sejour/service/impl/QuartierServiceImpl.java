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
	private QuartierDao quartiesDao;
	
	
	public Quartier getOne(Long id) {
		return quartiesDao.getOne(id);
	}
	public int save(Secteur secteur) {
		return secteurService.save(secteur);
	}
	@Override
	public Quartier findByReference(String reference) {
		return quartiesDao.findByReference(reference);
	}
	@Override
	public List<Quartier> findBySecteurReference(String reference) {
		return quartiesDao.findBySecteurReference(reference);
	}
	@Override
	@Transactional
	public int deleteByReference(String reference) {
		return quartiesDao.deleteByReference(reference);
	}
	@Override
	public int save(Secteur secteur, List<Locale> locales, List<Quartier> quartiers) {
		for(Quartier quartie : quartiers) {
			quartie.setSecteur(secteur);
			quartiesDao.save(quartie);
		}
		
		return 1;
	}
	

	

}
