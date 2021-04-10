package com.gestionhotel.sejour.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.bean.TaxeSejour;
import com.gestionhotel.sejour.dao.LocaleDao;
import com.gestionhotel.sejour.vo.LocaleServiceVo;

@Service
public class LocaleService implements LocaleServiceVo{

	@Autowired
	private LocaleDao localeDao;
	@Autowired
	private LocaleService localeService;
	@Autowired
	private QuartierService quartierService;

	@Transactional
	public int deleteByQuartierReference(String ref) {
		return localeDao.deleteByQuartierReference(ref);
	}

	public List<Locale> findByQuartierReference(String ref) {
		return localeDao.findByQuartierReference(ref);
	}
	public List<Locale> findByRedevableRef(String redevable) {
		return localeDao.findByRedevableRef(redevable);
	}

	public Locale getOne(Long id) {
		return localeDao.getOne(id);
	}

	@Autowired 
	private TaxeSejoureService  taxeSejourService;

	public Locale findAllByRedevableRef(String ref) {
		return localeDao.findAllByRedevableRef(ref);
	}

	public int deleteByRedevableRef(String ref) {
		return localeDao.deleteByRedevableRef(ref);
	}



	public List<Locale> findByRedevable(String refRe) {
		return localeDao.findByRedevableRef(refRe);
	}

	public List<Locale> findByCategorieRef(String refCat) {
		return localeDao.findByCategorieRef(refCat);
	}



	public List<Locale> findAll() {
		return localeDao.findAll();
	}
	@Autowired 
	RedevableService redevableservice;
	@Autowired
	SecteurService secteurrservice;
	@Autowired 
	CategorieService categorieservice;
	
	public int save(Locale locale) {
		Locale monlocale = findByReference(locale.getReference());
		Redevable redevable = redevableservice.findByRef(locale.getRedevable().getRef()) ;
		Categorie categorie = categorieservice.findByRef(locale.getCategorie().getRef()) ;
		Quartier quartier = quartierService.findByReference(locale.getQuartier().getReference());
		List<Locale> listlocales = localeService.findByQuartierReference(locale.getQuartier().getReference());
		List<TaxeSejour> tax = locale.getTaxessejour();
		if (redevable == null && categorie == null && quartier == null) {
			return -1;
		}
		else{
			int result = 1;
			for (Locale locales : listlocales) {
				if(locales.getReference().equals(locale.getReference())) {
					result = -1;
				}
			}if(result == -1) return -2;
			else{
				locale.setRedevable(redevable);
				locale.setCategorie(categorie);
				locale.setQuartier(quartier);
				localeDao.save(locale);
				return 1;
			}
		}
	}


	public int deleteByReference(String ref) {
		
		int deleteByLocaleReference= taxeSejourService.deleteByLocaleReference(ref);
		int deleteByref=localeDao.deleteByReference(ref);
		return deleteByref+deleteByLocaleReference;
	}

	public Locale findByReference(String ref) {
		return localeDao.findByReference(ref);

	}

	@Override
	public int save(Quartier quartier, List<Locale> locales) {
		for(Locale locale : locales) {
			locale.setQuartier(quartier);
			localeService.save(locale);
		}

		return 1;
	}
}
