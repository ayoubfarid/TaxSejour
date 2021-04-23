package com.gestionhotel.sejour.ws;
import java.util.List;

import com.gestionhotel.sejour.bean.TaxeSejour;
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
@RequestMapping("/taxe-sejour/locale")
public class LocaleWs {
	@Autowired
	private LocaleService localeServiceImpl;

	@DeleteMapping("/quartier/reference/{ref}")
	public int deleteByQuartierReference(@PathVariable String ref) {
		return localeServiceImpl.deleteByQuartierReference( ref);
	}

	@GetMapping("/quartier/reference/{ref}")
	public List<Locale> findByQuartierReference(@PathVariable String ref) {
		return localeServiceImpl.findByQuartierReference(ref);
	}

	@GetMapping("/redevable/ref/{ref}")
	public Locale findAllByRedevableRef(@PathVariable String ref) {
		return localeServiceImpl.findAllByRedevableRef(ref);
	}


	@DeleteMapping("/redevable/ref/{ref}")
	public int deleteByRedevableRef(@PathVariable String ref) {
		return localeServiceImpl.deleteByRedevableRef(ref);
	}


	@PostMapping("/")
	public int save(@RequestBody Locale locale) {
		return localeServiceImpl.save(locale);}
	
	@GetMapping("/")
	public List<Locale> findAll() {
		return localeServiceImpl.findAll();
	}

	@GetMapping("/id/{id}")
	public Locale getOne(@PathVariable Long id) {
		return localeServiceImpl.getOne(id);
	}


	@GetMapping("/Redevable/{refRe}")
	public List<Locale> findByRedevableRef(String refRe) {
		return localeServiceImpl.findByRedevableRef(refRe);}

	public List<Locale> findByRedevable(@PathVariable  String refRe) {
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
