package com.gestionhotel.sejour.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.dao.QuartierDao;
import com.gestionhotel.sejour.vo.QuartierServiceVo;

@Service
public class QuartierService implements QuartierServiceVo {

	
	@Autowired
	private QuartierDao quartierDao;
	@Autowired
	private SecteurService secteurService;

	@Transactional
	public int deleteBySecteurReference(String reference) {
		return quartierDao.deleteBySecteurReference(reference);
	}

	public int save(Quartier quartier) {
		Quartier isExit = findByReference(quartier.getReference());
		Secteur isExitSecteur = secteurService.findByReference(quartier.getSecteur().getReference());
		if(isExit != null)
			return -1;
		if(isExitSecteur == null)
			return -2;
		else {
			quartier.setSecteur(isExitSecteur);
			quartierDao.save(quartier);
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
		return quartierDao.deleteByReference(reference);
	}

	@Override
	public int save(Secteur secteur, List<Quartier> quartiers) {
		for(Quartier quartie : quartiers) {
			quartie.setSecteur(secteur);
			quartierDao.save(quartie);
		}
		
		return 1;
	}
	

	

}
