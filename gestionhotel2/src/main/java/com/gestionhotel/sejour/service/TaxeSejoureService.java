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
	 public  List<TaxeSejour> findByRedevableRefAndLocaleRef(String refredevable,String reflocale) {
		 return taxesejourdao.findByRedevableRefAndLocaleRef(refredevable, reflocale);
	 }
	 public TaxeSejour findByAnneeAndLocaleRefAndTrimAndRedevableRef(int annee,String locale,int trim,String red) {
		 return taxesejourdao.findByAnneeAndLocaleRefAndTrimAndRedevableRef(annee, locale, trim, red);
	 }
	 
	public int deleteByRedevableRefAndLocaleRef(String red, String loca) {
		return taxesejourdao.deleteByRedevableRefAndLocaleRef(red, loca);
	}
	

	public int deleteByRedevableRef(String s) {
		return taxesejourdao.deleteByRedevableRef(s);
	}

	public List<TaxeSejour> findAll() {
		return taxesejourdao.findAll();
	}

	public int save(TaxeSejour s) {
		Locale locale=localeservice.findByRef(s.getLocale().getRef());
		s.setLocale(locale);
		if (locale==null ) {
			return  -1;
		} 
		Redevable redevable=redevableservice.findByRef(s.getRedevable().getRef());
	  	s.setRedevable(redevable);
		if (redevable==null){
			return  -2;
		} /*!*/
		if(locale.getRedevable().getRef()!=redevable.getRef()){
			return -3;
		}
		else if(findByAnneeAndLocaleRefAndTrimAndRedevableRef(s.getAnnee(),s.getLocale().getRef(),s.getTrim(),s.getRedevable().getRef())!=null){
			return -4;
		}
		
		else  {/*!*/
			if(s.getmontantBase()!=locale.getCategorie().getTautaxsejour().getMontantNuite()*s.getNombreNuite()) {
			double m=locale.getCategorie().getTautaxsejour().getMontantNuite()*s.getNombreNuite();
				s.setmontantBase(m);
			}
			taxesejourdao.save(s);	
			return 1;
			}
			
	
	}
			}



