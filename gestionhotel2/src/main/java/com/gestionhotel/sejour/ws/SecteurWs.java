package com.gestionhotel.sejour.ws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.service.impl.SecteurServiceImpl;

@RestController
@RequestMapping("locale-api/monlocale")

public class SecteurWs {

	@Autowired
	private SecteurServiceImpl secteurServiceImpl;

	public Secteur findByReference(String ref) {
		return secteurServiceImpl.findByReference(ref);
	}

	public int deleteByReference(String ref) {
		return secteurServiceImpl.deleteByReference(ref);
	}

	public int save(Secteur secteur) {
		return secteurServiceImpl.save(secteur);
	}

	public int hashCode() {
		return secteurServiceImpl.hashCode();
	}

	public boolean equals(Object obj) {
		return secteurServiceImpl.equals(obj);
	}

	public String toString() {
		return secteurServiceImpl.toString();
	}
	
	
	
}
