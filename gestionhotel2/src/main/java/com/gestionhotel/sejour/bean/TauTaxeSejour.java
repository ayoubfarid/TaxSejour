package com.gestionhotel.sejour.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;




@Entity
public class TauTaxeSejour {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private double montantNuite;
	
	
	@JsonProperty(access  = Access.WRITE_ONLY)
	@ManyToOne
	private Categorie categorie;	
	
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public  Long getId() {
		return id;
	}
	public void setId( Long id) {
		this.id = id;
	}
	
	
	public double getMontantNuite() {
		return montantNuite;
	}
	public void setMontantNuite(double montantNuite) {
		this.montantNuite = montantNuite;
	}

	
}
