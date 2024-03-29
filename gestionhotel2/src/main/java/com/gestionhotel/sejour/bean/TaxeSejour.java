package com.gestionhotel.sejour.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TaxeSejour {
	@Id @GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	private int annee;
	private int trim;
	private double nombreNuite;
	private double montantBase;
	@ManyToOne
	private Locale locale;
	@ManyToOne
	private Redevable redevable;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public Redevable getRedevable() {
		return redevable;
	}
	public void setRedevable(Redevable redevable) {
		this.redevable = redevable;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getTrim() {
		return trim;
	}
	public void setTrim(int trim) {
		this.trim = trim;
	}
	public double getNombreNuite() {
		return nombreNuite;
	}
	public void setNombreNuite(double nombreNuite) {
		this.nombreNuite = nombreNuite;
	}
	
	public double getmontantBase() {
		return montantBase;
	}
	public void setmontantBase(double bmontantBase) {
		this.montantBase = bmontantBase;
	}
	public TaxeSejour() {
		super();
	}
	



}
