package com.gestionhotel.sejour.bean;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Locale implements Serializable {

	private static final long serialVersionUID = 1L; 
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	@ManyToOne
	private Redevable redevable;
	@ManyToOne
	private Secteur secteur;
	@ManyToOne
	private Categorie categorie;
	@OneToMany(mappedBy = "locale")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<TaxeSejour> taxessejour;

	public List<TaxeSejour> getTaxessejour() {
		return taxessejour;
	}

	public void setTaxessejour(List<TaxeSejour> taxessejour) {
		this.taxessejour = taxessejour;
	}

	public Secteur getSecteur() {
		return secteur;
	}
	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String ref) {
		this.reference = ref;
	}

	public Redevable getRedevable() {
		return redevable;
	}
	public void setRedevable(Redevable redevable) {
		this.redevable = redevable;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
}
