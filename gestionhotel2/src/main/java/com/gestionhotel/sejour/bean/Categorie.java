package com.gestionhotel.sejour.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ref;
	private String libelle;
	
	
	@OneToMany(mappedBy = "categorie")
	List<TauTaxeSejour> tautaxsejours = new ArrayList<TauTaxeSejour>();
	
	public List<TauTaxeSejour> getTautaxsejours() {
		return tautaxsejours;
	}

	public void setTautaxsejours(List<TauTaxeSejour> tautaxsejours) {
		this.tautaxsejours = tautaxsejours;
	}

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

	
	
	
	
	

}
