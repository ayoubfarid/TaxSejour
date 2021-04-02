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

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.service.LocaleService;
@RestController@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("v2-stock-app20/locale")
public class LocaleWs {
	@Autowired
	private LocaleService localeServiceImpl;

	@PostMapping("/")
	public int save(@RequestBody Locale locale) {
		return localeServiceImpl.save(locale);
	}


	@GetMapping("/")
	public List<Locale> findAll() {
		return localeServiceImpl.findAll();
	}

	@GetMapping("/id/{id}")
	public Locale getOne(@PathVariable Long id) {
		return localeServiceImpl.getOne(id);
	}

	@DeleteMapping("/secteur/reference/{ref}")
	public int deleteBySecteurReference(@PathVariable String ref) {
		return localeServiceImpl.deleteBySecteurReference(ref);
	}

	@GetMapping("/secteur/reference/{ref}")
	public List<Quartier> findBySecteurReference(@PathVariable String ref) {
		return localeServiceImpl.findBySecteurReference(ref);
	}
	@GetMapping("/Redevable/{refRe}")
	public List<Locale> findByRedevable(String refRe) {
		return localeServiceImpl.findByRedevable(refRe);
	}
	@GetMapping("/reference/{ref}")
	public Locale findByReference(@PathVariable String ref) {
		return localeServiceImpl.findByReference(ref);
	}


	@GetMapping("/categorie/ref/{refategorie}")
	public List<Locale> findByCategorieRef(@PathVariable String refcategorie) {
		return localeServiceImpl.findByCategorieRef(refcategorie);
	}

	
	@DeleteMapping("/ref/{ref}")
	public int deleteByReference(@PathVariable String ref) {
		return localeServiceImpl.deleteByReference(ref);
	}

	public int hashCode() {
		return localeServiceImpl.hashCode();
	}

	public boolean equals(Object obj) {
		return localeServiceImpl.equals(obj);
	}

	public String toString() {
		return localeServiceImpl.toString();
	}
	
	
	
}
