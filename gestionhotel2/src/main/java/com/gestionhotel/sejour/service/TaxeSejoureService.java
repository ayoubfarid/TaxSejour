package com.example.j2ee.projet1.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.j2ee.projet1.Dao.TaxeSejourDao;
import com.example.j2ee.projet1.bean.TaxeSejour;

@Service
public class TaxeSejoureService {

Date  date= new Date();
SimpleDateFormat forme =new SimpleDateFormat("yyyy");
 String An=forme.format(date);
 int AnneeActuelle=Integer.valueOf(An);
 @Autowired
   private  TaxeSejourDao  taxesejourdao;
 
public  List<TaxeSejour> findByRefRedevable(String refredevable) {
	return taxesejourdao.findByRefRedevable(refredevable);
}
public TaxeSejour findByRefRedevableAndReflocale(String red,String locale) {
	return  findByRefRedevableAndReflocale( red, locale);
}
public   TaxeSejour findByAnneeAndReflocaleAndMontantNuiteAndTrim(int annee,String locale,double montant,int trimestre) {
	return findByAnneeAndReflocaleAndMontantNuiteAndTrim( annee, locale, montant, trimestre);
}
  public   TaxeSejour findByAnneeAndReflocaleAndTrimAndAndRefRedevable(int annee,String locale,int trim,String red) {
	return taxesejourdao.findByAnneeAndReflocaleAndTrimAndRefRedevable(annee, locale,trim,red);
 }

public List<TaxeSejour> findByReflocale(String reflocale) {
	return taxesejourdao.findByReflocale(reflocale);
}

public List<TaxeSejour> findAll() {
	return taxesejourdao.findAll();
}

public int save(TaxeSejour s) {
	if (findByAnneeAndReflocaleAndTrimAndAndRefRedevable(s.getAnnee(),s.getReflocale(),s.getTrim(),s.getRefRedevable())!=null ) {
		return  -1;
	} 

	// if(findByRef(s.getMontantNuite() )!=null pour verifier si le montant nuite existe dans la table TauTax
	/*findByRef1(s.getReflocale())!=null et findByRef2(s.getRefRedevable())!=null pour verifier si les references de locale et  de redevable 
	  existent deja dans les tables local et redevable*/
	
	/*if(findByRef(s.getMontantNuite() )!=null || findByRef1(s.getReflocale())!=null || findByRef2(s.getRefRedevable())!=null){
		return -2;
	}*/
	else if (findByAnneeAndReflocaleAndMontantNuiteAndTrim(s.getAnnee() ,s.getReflocale(), s.getMontantNuite(), s.getTrim())!=null ) {
		return -2;
	}
	else  if(s.getMontantNuite()*s.getNombreNuite()!=s.getmontantBase()) {
		return -3;	
	}
	else if( findByRefRedevableAndReflocale(s.getRefRedevable(), s.getReflocale())!=null){
		return -5;
	}
	else {
		taxesejourdao.save(s);
	return 1;
	}}
	
	
		
	}
			 





