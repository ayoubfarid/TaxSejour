package com.gestionhotel.sejour.bean;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Locale implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final long SerialVersionUID=1L; 
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ref;
	private String adresse;
	private String rue;
	@ManyToOne
	private Redevable redevable;
	@ManyToOne
	private Categorie categorie;
	@OneToMany
	private List<TaxeSejour> taxeSejour;
	
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
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
	public List<TaxeSejour> getTaxeSejour() {
		return taxeSejour;
	}
	public void setTaxeSejour(List<TaxeSejour> taxeSejour) {
		this.taxeSejour = taxeSejour;
	}
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	
	
}
