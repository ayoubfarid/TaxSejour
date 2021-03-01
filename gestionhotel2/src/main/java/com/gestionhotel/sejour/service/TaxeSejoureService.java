package com.gestionhotel.sejour.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.bean.TaxeSejour;
import com.gestionhotel.sejour.dao.TaxeSejourDao;

@Service
public class TaxeSejoureService {

	 @Autowired
	   private  TaxeSejourDao  taxesejourdao;
	@Autowired
	private LocaleService localeservice;
	@Autowired
	private RedevableService redevableservice;
	 public	List<TaxeSejour> findByLocaleRef(String reference){
		return  taxesejourdao.findByLocaleRef(reference);
	 }

	 public List<TaxeSejour>  findByRedevableRef(String reference){
		 return taxesejourdao.findByRedevableRef(reference);
	 }
	 public TaxeSejour findByRedevableRefAndLocaleRef(String refredevable,String reflocale) {
		 return taxesejourdao.findByRedevableRefAndLocaleRef(refredevable, reflocale);
	 }
	 public TaxeSejour findByAnneeAndLocaleRefAndTrimAndRedevableRef(int annee,String locale,int trim,String red) {
		 return taxesejourdao.findByAnneeAndLocaleRefAndTrimAndRedevableRef(annee, locale, trim, red);
	 }
	public List<TaxeSejour> findAll() {
		return taxesejourdao.findAll();
	}

	public int save(TaxeSejour s) {
		Locale locale=localeservice.findByRef(s.getLocale().getRef());
		if (locale==null ) {
			return  -1;
		} 
		Redevable redevable=redevableservice.findByRef(s.getRedevable().getRef());
	  	
		if (redevable==null){
			return  -2;
		} 
		if(findByRedevableRefAndLocaleRef(s.getRedevable().getRef(),s.getLocale().getRef())!=null){
			return -3;
		}
		else if(findByAnneeAndLocaleRefAndTrimAndRedevableRef(s.getAnnee(),s.getLocale().getRef(),s.getTrim(),s.getRedevable().getRef())!=null){
			return -4;
		}
		
		else  {
			if(s.getMontantNuite()*s.getNombreNuite()!=s.getmontantBase()) {
				double m=s.getMontantNuite()*s.getNombreNuite();
				s.setmontantBase(m);
				taxesejourdao.save(s);
			}
			else {
				taxesejourdao.save(s);
			}
			
		return 1;
			}
	}
 
	
		
	}
			 





