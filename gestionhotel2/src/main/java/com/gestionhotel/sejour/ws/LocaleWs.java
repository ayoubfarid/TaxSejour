package com.example.projet1.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projet1.beans.Locale;
import com.example.projet1.service.LocaleService;

@RestController
@RequestMapping("locale-api/monlocale")

public class LocaleWs {
	
	@Autowired
	private LocaleService localeService;

	@GetMapping("/refRedevable/{refRedevable}")
	public List<Locale> findByRefRedevable(@PathVariable String refRedevable) {
		return localeService.findByRefRedevable(refRedevable);
	}

	@GetMapping("/refCategorie/{refCategorie}")
	public List<Locale> findByRefCategorie(@PathVariable String refCategorie) {
		return localeService.findByRefCategorie(refCategorie);
	}

	@GetMapping("/ref/{ref}")
	public Locale findByRef(@PathVariable String ref) {
		return localeService.findByRef(ref);
	}

	@GetMapping("/")
	public List<Locale> findAll() {
		return localeService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Locale locale) {
		return localeService.save(locale);
	}

	public int hashCode() {
		return localeService.hashCode();
	}

	public boolean equals(Object obj) {
		return localeService.equals(obj);
	}

	public String toString() {
		return localeService.toString();
	}
	
	
	
}
