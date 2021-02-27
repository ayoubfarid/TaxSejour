package com.example.j2ee.projet1.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaxeSejour {
	@Id @GeneratedValue(strategy =GenerationType.AUTO)
  private Long id;
  private String refRedevable;
  private String reflocale;
  private int annee;
  private int trim;
  private double nombreNuite;
  private double montantNuite ;
  private double montantBase;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getRefRedevable() {
	return refRedevable;
}
public void setRefRedevable(String refRedevable) {
	this.refRedevable = refRedevable;
}
public String getReflocale() {
	return reflocale;
}
public void setReflocale(String reflocale) {
	this.reflocale = reflocale;
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
public double getMontantNuite() {
	return montantNuite;
}
public void setMontantNuite(double montantNuite) {
	this.montantNuite = montantNuite;
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
public TaxeSejour(Long id, String refRedevable, String reflocale, int annee, int trim, double nombreNuite,
		double montantNuite, double montantBase) {
	super();
	this.id = id;
	this.refRedevable = refRedevable;
	this.reflocale = reflocale;
	this.annee = annee;
	this.trim = trim;
	this.nombreNuite = nombreNuite;
	this.montantNuite = montantNuite;
	this.montantBase =montantBase;
}
  
  
  
}
