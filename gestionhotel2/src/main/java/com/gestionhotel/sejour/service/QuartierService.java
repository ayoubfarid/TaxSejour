package com.gestionhotel.sejour.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Locale;
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
	@Autowired
	private QuartierService quartierService;
	@Autowired
	private LocaleService localeService;

	@Transactional
	public int deleteBySecteurReference(String reference) {
		return quartierDao.deleteBySecteurReference(reference);
	}

	public int save(Quartier quartier) {
		Secteur isExitSecteur = secteurService.findByReference(quartier.getSecteur().getReference());
		List<Quartier> quartierss = quartierService.findBySecteurReference(quartier.getSecteur().getReference());
		if(isExitSecteur == null) {
			return -1;
		}else{
			int result = 1;
			for (Quartier quartier2 : quartierss) {
				if(quartier2.getReference().equals(quartier.getReference())) {
					System.out.println("\n\n\n\n\n"+quartier.getReference());
					System.out.println("\n\n\n\n\n"+quartier2.getReference());
					result = -1;
				}
		    }if(result == -1) return -3;
		    else{
				List<Locale> loc = quartier.getLocales();
				quartier.setSecteur(isExitSecteur);
				quartierDao.save(quartier);
				localeService.save(quartier , loc);
				return 1;
			}
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
		int res1 = quartierDao.deleteByReference(reference);
		//int res2 = localeService.deleteByQuartierReference(reference);
		return res1;
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
