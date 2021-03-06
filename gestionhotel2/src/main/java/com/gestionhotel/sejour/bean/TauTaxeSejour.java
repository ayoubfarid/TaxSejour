package com.gestionhotel.sejour.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class TauTaxeSejour {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double montantNuite;
	
	
	
	@OneToOne
	private Categorie categorie;	
	
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public  long getId() {
		return id;
	}
	public void setId( long id) {
		this.id = id;
	}
	
	
	public double getMontantNuite() {
		return montantNuite;
	}
	public void setMontantNuite(double montantNuite) {
		this.montantNuite = montantNuite;
	}

	
}
