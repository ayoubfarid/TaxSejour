package com.gestionhotel.sejour.vo;

public class TaxeSejourVo {
    public String getReflo() {
        return reflo;
    }

    public void setReflo(String reflo) {
        this.reflo = reflo;
    }

    public Double getMontantbasemin() {
        return montantbasemin;
    }

    public void setMontantbasemin(Double montantbasemin) {
        this.montantbasemin = montantbasemin;
    }

    public Double getMontantbasemax() {
        return montantbasemax;
    }

    public void setMontantbasemax(Double montantbasemax) {
        this.montantbasemax = montantbasemax;
    }

    private String reflo;
    private Double montantbasemin;
    private Double montantbasemax;

}
