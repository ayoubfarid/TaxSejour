 package com.gestionhotel.sejour.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

 @Entity
public class Redevable implements Serializable {
   
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    @ManyToOne
    private RedevableType type;
    @OneToMany(mappedBy = "redevable")
	@JsonProperty(access = Access.WRITE_ONLY)
    private List<Locale> locales = new ArrayList<Locale>();
    
    public List<Locale> getLocales() {
		return locales;
	}
	public void setLocales(List<Locale> locales) {
		this.locales = locales;
	}
	public String getRef() {
        return ref;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }
    public RedevableType getType() {
        return type;
    }
    public void setType(RedevableType type) {
        this.type = type;}


 }