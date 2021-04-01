package com.gestionhotel.sejour.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Quartier implements Serializable {

	private static final long serialVersionUID = 1L; 
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private String nomQuartier;
	@ManyToOne
	private Secteur secteur;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getNomQuartier() {
		return nomQuartier;
	}
	public void setNomQuartier(String nomQuartier) {
		this.nomQuartier = nomQuartier;
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

}
