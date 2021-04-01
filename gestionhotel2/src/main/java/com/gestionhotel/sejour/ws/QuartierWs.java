package com.gestionhotel.sejour.ws;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.service.QuartierService;

@RestController
@CrossOrigin( origins = {"http://localhost:4200"} )
@RequestMapping("v1-app3/monQuartier")

public class QuartierWs {
	
	@Autowired
	private QuartierService quartierService;

	@PostMapping("/")
	public int save(@RequestBody Quartier quartier) {
		return quartierService.save(quartier);
	}

	@GetMapping("/id/{id}")
	public Quartier getOne(Long id) {
		return quartierService.getOne(id);
	}

	@GetMapping("/reference/{reference}")
	public Quartier findByReference(@PathVariable  String reference) {
		return quartierService.findByReference(reference);
	}


	@GetMapping("/secteur/reference/{reference}")
	public List<Quartier> findBySecteurReference(@PathVariable  String reference) {
		return quartierService.findBySecteurReference(reference);
	}

	@DeleteMapping("/")
	public int deleteByReference(@PathVariable  String reference) {
		return quartierService.deleteByReference(reference);
	}


	public int hashCode() {
		return quartierService.hashCode();
	}

	public boolean equals(@PathVariable  Object obj) {
		return quartierService.equals(obj);
	}

	public String toString() {
		return quartierService.toString();
	}

	
	
	/*
	public int deleteByReference(String ref) {
		return localeService.deleteByReference(ref);
	}
	@GetMapping("/id/{id}")
	public Locale getOne(@PathVariable Long monId) {
		return localeService.getOne(monId);
	}
	@GetMapping("/redevable/{redevable}")
	public List <Locale> findByRedevable(@PathVariable String redevable) {
		return localeService.findByRedevable(redevable);
	}
	@GetMapping("/refCategorie/{Categorie}")
	public List<Locale>findByCategorieRef(@PathVariable String categorie) {
		return localeService.findByCategorieRef(categorie);
	}
	@GetMapping("/ref/{ref}")
	public Locale findByReference(@PathVariable String ref) {
		return localeService.findByReference(ref);
	}
	@GetMapping("/")
	public List<Locale> findAll() {
		return localeService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Locale locale) {
		return localeService.save(locale);
	}

	*/
	
	
	
}
