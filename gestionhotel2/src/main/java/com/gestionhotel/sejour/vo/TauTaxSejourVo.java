package com.gestionhotel.sejour.vo;

public class TauTaxSejourVo {
	private long id;
	private double montantNuiteMin;
	private double montantNuiteMax;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getMontantNuiteMin() {
		return montantNuiteMin;
	}
	public void setMontantNuiteMin(double montantNuiteMin) {
		this.montantNuiteMin = montantNuiteMin;
	}
	public double getMontantNuiteMax() {
		return montantNuiteMax;
	}
	public void setMontantNuiteMax(double montantNuiteMax) {
		this.montantNuiteMax = montantNuiteMax;
	}

}
