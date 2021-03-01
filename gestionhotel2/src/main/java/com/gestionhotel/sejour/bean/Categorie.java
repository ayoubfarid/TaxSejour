package com.gestionhotel.sejour.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Categorie {
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ref;
	private String libelle;
	
	@OneToOne 
	private TauTaxeSejour tautaxsejour;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public TauTaxeSejour getTautaxsejour() {
		return tautaxsejour;
	}

	public void setTautaxsejour(TauTaxeSejour tautaxsejour) {
		this.tautaxsejour = tautaxsejour;
	}
	
	
	
	

}