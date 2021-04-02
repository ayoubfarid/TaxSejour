package com.gestionhotel.sejour.service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.gestionhotel.sejour.vo.TaxeSejourVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	 public	List<TaxeSejour> findByLocaleReference(String reference){
		return  taxesejourdao.findByLocaleReference(reference);
	 }
     
	 public List<TaxeSejour>  findByRedevableRef(String reference){
		 return taxesejourdao.findByRedevableRef(reference);
	 }
	 public  List<TaxeSejour> findByRedevableRefAndLocaleReference(String refredevable,String reflocale) {
		 return taxesejourdao.findByRedevableRefAndLocaleReference(refredevable, reflocale);
	 }
	 public TaxeSejour findByAnneeAndLocaleReferenceAndTrimAndRedevableRef(int annee,String locale,int trim,String red) {
		 return taxesejourdao.findByAnneeAndLocaleReferenceAndTrimAndRedevableRef(annee, locale, trim, red);
	 }
	 @Transactional
	public int deleteByRedevableRefAndLocaleReference(String red, String loca) {
		return taxesejourdao.deleteByRedevableRefAndLocaleReference(red, loca);
	}
	 @Transactional
	public int deleteByRedevableRef(String s) {
		return taxesejourdao.deleteByRedevableRef(s);
	}
	 @Transactional
	 public int deleteByLocaleReference(String s) {
		return	taxesejourdao.deleteByLocaleReference(s);
		}
	
	public List<TaxeSejour> findByAnneespecifique(int an) {
		return taxesejourdao.findByAnneespecifique(an);
	}
 public List<TaxeSejourVo>  findByTrimestre(TaxeSejourVo vo){
	  String query="Select t from TaxeSejour t where 1=1";
	  if(vo.getReflo()!=null && !vo.getReflo().isEmpty()) {
		  query+="  And l.ref='" +vo.getReflo()+"' ";  
	  }
	  if(vo.getMontantbasemax()!=null) {
		  query+="   And t.montantbase<= "+vo.getMontantbasemax();
	  }
	  if(vo.getMontantbasemin()!=null) {
		  query+="   And t.montantbase >=+ "+vo.getMontantbasemin();
	  }
	  return   entity.createQuery(query).getResultList();
  }

	public int save(TaxeSejour s) {
		Locale locale=localeservice.findByRef(s.getLocale().getReference());
		s.setLocale(locale);
		if (locale==null ) {
			return  -1;
		} 
		Redevable redevable=redevableservice.findByRef(s.getRedevable().getRef());
	  	s.setRedevable(redevable);
		if (redevable==null){
			return  -2;
		} 
		if(locale.getRedevable().getRef()!=redevable.getRef()){
			return -3;
		}
		else if(findByAnneeAndLocaleReferenceAndTrimAndRedevableRef(s.getAnnee(),s.getLocale().getReference(),s.getTrim(),s.getRedevable().getRef())!=null){
			s.setAnnee(s.getAnnee());
			s.setLocale(locale);
			s.setRedevable(redevable);
			s.setmontantBase(s.getmontantBase());
			s.setNombreNuite(s.getNombreNuite());
			s.setTrim(s.getTrim());
			taxesejourdao.save(s);
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
	@Autowired
	private EntityManager entity;
			}



