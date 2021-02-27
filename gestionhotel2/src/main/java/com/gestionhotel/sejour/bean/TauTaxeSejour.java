package com.gestionhotel.sejour.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class TauTaxeSejour {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String refCategorie;
	private double montantNuite;
	public  long getId() {
		return id;
	}
	public void setId( long id) {
		this.id = id;
	}
	public String getRefCategorie() {
		return refCategorie;
	}
	public void setRefCategorie(String refCategorie) {
		this.refCategorie = refCategorie;
	}
	public double getMontantNuite() {
		return montantNuite;
	}
	public void setMontantNuite(double montantNuite) {
		this.montantNuite = montantNuite;
	}

	
}
