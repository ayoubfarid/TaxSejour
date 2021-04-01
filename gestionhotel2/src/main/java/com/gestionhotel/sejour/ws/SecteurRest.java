package com.gestionhotel.sejour.ws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.service.SecteurService;

@RestController
@CrossOrigin( origins = {"http://localhost:4200"} )
@RequestMapping("v3-app/monSecteur")
public class SecteurRest {

	@Autowired
	private SecteurService secteurServiceImpl;

	@GetMapping("reference/{ref}")
	public Secteur findByReference(@PathVariable String ref) {
		return secteurServiceImpl.findByReference(ref);
	}

	@DeleteMapping("/reference/{ref}")
	public int deleteByReference(@PathVariable String ref) {
		return secteurServiceImpl.deleteByReference(ref);
	}

	@PostMapping("/")
	public int save(@RequestBody Secteur secteur) {
		return secteurServiceImpl.save(secteur);
	}

	public int hashCode() {
		return secteurServiceImpl.hashCode();
	}

	public boolean equals(@PathVariable Object obj) {
		return secteurServiceImpl.equals(obj);
	}

	public String toString() {
		return secteurServiceImpl.toString();
	}
	
	
	
}
