package com.example.j2ee.projet1.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.j2ee.projet1.bean.TaxeSejour;
import com.example.j2ee.projet1.Service.TaxeSejoureService;

@RestController
@RequestMapping("gestiontaxesejour/taxesejour")
public class TaxeSejourRest {
	@Autowired
	TaxeSejoureService taxesejourservice;
 @GetMapping("/referenceredevable/{refredevable}")
	public  List<TaxeSejour> findByRefRedevable(@PathVariable  String refredevable) {
		return taxesejourservice.findByRefRedevable(refredevable);
	}
 //@GetMapping("/montantnuite/{montant}")
 @GetMapping("/referenceredevable/{red}/referencelocale/{reflocale}")
public TaxeSejour findByRefRedevableAndReflocale(@PathVariable String red, @PathVariable String locale) {
	return taxesejourservice.findByRefRedevableAndReflocale(red, locale);
}
 @GetMapping("/annee/{annee}/reerencelocale/{locale}/montantnuite/{montant}/trimestre/trimemstre")
public TaxeSejour findByAnneeAndReflocaleAndMontantNuiteAndTrim(int annee, String locale, double montant,int trimestre) {
	return taxesejourservice.findByAnneeAndReflocaleAndMontantNuiteAndTrim(annee, locale, montant, trimestre);
}
@GetMapping("/annee/{annee}/reerencelocale/{locale}/trimestre/trim/referenceredevable/{refredevable}")
public TaxeSejour findByAnneeAndReflocaleAndTrimAndRefRedevable(@PathVariable int annee,@PathVariable String locale,@PathVariable int trim,String red) {
	return taxesejourservice.findByAnneeAndReflocaleAndTrimAndAndRefRedevable(annee, locale,trim,red);
 }
@GetMapping("/referencelocale/{reflocale}")
	public List<TaxeSejour> findByReflocale(@PathVariable String reflocale) {
		return taxesejourservice.findByReflocale(reflocale);
	}
@GetMapping("/")
	public List<TaxeSejour> findAll() {
		return taxesejourservice.findAll();
	}
@PostMapping("/")
	public int save( @RequestBody  TaxeSejour s) {
		return taxesejourservice.save(s);
	}
//@PutMapping("/nuitdeplus/referenceredevable/{redevable}/referencelocale/{locale}/nombrenuite/{nbrnuite}")
   
	public int hashCode() {
		return taxesejourservice.hashCode();
	}

	public boolean equals(Object obj) {
		return taxesejourservice.equals(obj);
	}

	public String toString() {
		return taxesejourservice.toString();
	}
	

}
