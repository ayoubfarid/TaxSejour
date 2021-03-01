package com.gestionhotel.sejour.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionhotel.sejour.bean.TaxeSejour;
import com.gestionhotel.sejour.service.TaxeSejoureService;

@RestController
@RequestMapping("gestiontaxesejour/taxesejour")
public class TaxeSejourRest {
	
	@Autowired
	TaxeSejoureService taxesejourservice;
	@GetMapping("/referencelocale/{reference}")
	 public	List<TaxeSejour> findByLocaleRef(@PathVariable String reference){
		return  taxesejourservice.findByLocaleRef(reference);
	 }
	@GetMapping("/referenceredevable/{reference}")
public List<TaxeSejour> findByRedvableRef(@PathVariable String reference) {
		return taxesejourservice.findByRedvableRef(reference);
	}
	@GetMapping("/referenceredevable/{refredevable}/referencelocale/{reflocale}")
	public TaxeSejour findByRedevableRefAndLocaleRef(@PathVariable String refredevable, @PathVariable String reflocale) {
		return taxesejourservice.findByRedevableRefAndLocaleRef(refredevable, reflocale);
	}
	@GetMapping("/annee/{annee}/reerencelocale/{locale}/trimestre/trim/referenceredevable/{red}")
	public TaxeSejour findByAnneeAndLocaleRefAndTrimAndRedevableRef(@PathVariable int annee, @PathVariable String locale,@PathVariable int trim,@PathVariable String red) {
		return taxesejourservice.findByAnneeAndLocaleRefAndTrimAndRedevableRef(annee, locale, trim, red);
	}

@GetMapping("/")
	public List<TaxeSejour> findAll() {
		return taxesejourservice.findAll();
	}
@PostMapping("/")
	public int save( @RequestBody  TaxeSejour s) {
		return taxesejourservice.save(s);
	}
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


