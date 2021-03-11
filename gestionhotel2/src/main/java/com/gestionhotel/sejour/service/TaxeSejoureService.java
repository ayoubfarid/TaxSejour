package com.gestionhotel.sejour.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.bean.TauTaxeSejour;
import com.gestionhotel.sejour.bean.TaxeSejour;
import com.gestionhotel.sejour.dao.TaxeSejourDao;

@Service
public class TaxeSejoureService {

	
	@Autowired  
	TauTaxeSejourService tautaxesejourservice;
	
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
	 @Transactional
	public int deleteByRedevableRefAndLocaleRef(String red, String loca) {
		return taxesejourdao.deleteByRedevableRefAndLocaleRef(red, loca);
	}
	 @Transactional
	public int deleteByRedevableRef(String s) {
		return taxesejourdao.deleteByRedevableRef(s);
	}
	 @Transactional
	 public int deleteByLocaleRef(String s) {
		return	taxesejourdao.deleteByLocaleRef(s);
		}
	

	
  @GetMapping("/recherche-par-an/{an}")
	public List<TaxeSejour> findByAnneespecifique(int an) {
		return taxesejourdao.findByAnneespecifique(an);
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
		
		else  {
			TauTaxeSejour tautaxesejour=tautaxesejourservice.findByCategorieRef(locale.getCategorie().getRef());
			
				double montant=tautaxesejour.getMontantNuite()*s.getNombreNuite();
				s.setmontantBase(montant);
		
			
			taxesejourdao.save(s);	
			return 1;
			}
			
	
	}
			}



