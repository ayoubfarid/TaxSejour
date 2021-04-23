package com.gestionhotel.sejour.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.bean.TaxeSejour;
import com.gestionhotel.sejour.dao.QuartierDao;
import com.gestionhotel.sejour.vo.QuartierServiceVo;

@Service
public class QuartierService implements QuartierServiceVo {

	
	@Autowired
	private QuartierDao quartierDao;
	
	public List<Quartier> findAll() {
		return quartierDao.findAll();
	}

	@Autowired
	private SecteurService secteurService;
	@Autowired
	private QuartierService quartierService;
	@Autowired
	private LocaleService localeService;

	@Transactional
	public int deleteBySecteurReference(String reference) {
		int y = localeService.deleteByQuartierReference(reference);
		int x = quartierDao.deleteBySecteurReference(reference);
		return x+y;
	}

	@Override
	public int updateQuartier(Quartier quartier) {
		Quartier quartier2 = findByReference(quartier.getReference());
		if(null == quartier2) {
			return -1; 
		}else {
			quartier2.setNom(quartier.getNom());
			quartier2.setNum(quartier.getNum());
			quartierDao.save(quartier2);
			return 1;
		}
	}

	public int save(Quartier quartier) {
		Secteur isExitSecteur = secteurService.findByReference(quartier.getSecteur().getReference());
		Quartier isExistQuartRef = quartierDao.findByReference(quartier.getReference());
		if(isExitSecteur == null) {
			return -1;
		}else if(isExistQuartRef  != null){
			return -2;
		}else if(quartier.getReference().equals("")){
			return -3;
		}else{
			List<Locale> loc = quartier.getLocales();
			quartier.setSecteur(isExitSecteur);
			quartierDao.save(quartier);
			localeService.save(quartier , loc);
			return 1;
		}
		
	}

	public Quartier getOne(Long id) {
		return quartierDao.getOne(id);
	}
	
	public Quartier findByReference(String b) {
		return quartierDao.findByReference(b);
	}
	
	public List<Quartier> findBySecteurReference(String reference) {
		return quartierDao.findBySecteurReference(reference);
	}
	
	@Transactional
	public int deleteByReference(String reference) {
		int res2 = localeService.deleteByQuartierReference(reference);
		int res1 = quartierDao.deleteByReference(reference);
		return res1+res2;
	}

	@Override
	public int save(Secteur secteur, List<Quartier> quartiers) {
		for (Quartier quartier : quartiers) {
			quartier.setSecteur(secteur);
			quartierService.save(quartier);
		}
		return 1;
	}
	

	

}
