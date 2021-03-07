package com.gestionhotel.sejour.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.bean.TauTaxeSejour;
import com.gestionhotel.sejour.service.TauTaxeSejourService;

@RestController
@RequestMapping("gestiontaxesejour/tautaxesejour")

public class TauTaxeSejourRestApi {
	@Autowired
	private TauTaxeSejourService tautaxesejourservice;
	
	
	
	@GetMapping("/tautaxesejour/montant-nuite-greaterthan/{montant}")
	public List<TauTaxeSejour> findByMontantNuiteSuperieur(@PathVariable double montant) {
		return tautaxesejourservice.findByMontantNuiteSuperieur(montant);
	}

	@GetMapping("/tautaxesejour/montant-nuite/{montantnuite}")
	public TauTaxeSejour findByMontantNuite(@PathVariable double montantnuite) {
		return tautaxesejourservice.findByMontantNuite(montantnuite);
	}

	@GetMapping("/tautaxesejour/categorieRef/{RefCategorie}")
	public TauTaxeSejour findByCategorieRef(@PathVariable String RefCategorie) {
		return tautaxesejourservice.findByCategorieRef(RefCategorie);
	}
	
	@GetMapping("/tautaxesejour")
	public List<TauTaxeSejour> findAll() {
		return tautaxesejourservice.findAll();
	}
	@PostMapping("/tautaxesejour")
	public int save(@RequestBody TauTaxeSejour tautaxesejour) {
		return tautaxesejourservice.save(tautaxesejour);
	}
	
	public int hashCode() {
		return tautaxesejourservice.hashCode();
	}

	public boolean equals(Object obj) {
		return tautaxesejourservice.equals(obj);
	}

	public String toString() {
		return tautaxesejourservice.toString();
	}

}
