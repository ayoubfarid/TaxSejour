package com.gestionhotel.sejour.vo;

public class TauTaxSejourVo {
	private Long id;
	private Double montantNuiteMin;
	private Double montantNuiteMax;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getMontantNuiteMin() {
		return montantNuiteMin;
	}
	public void setMontantNuiteMin(double montantNuiteMin) {
		this.montantNuiteMin = montantNuiteMin;
	}
	public Double getMontantNuiteMax() {
		return montantNuiteMax;
	}
	public void setMontantNuiteMax(double montantNuiteMax) {
		this.montantNuiteMax = montantNuiteMax;
	}

}
