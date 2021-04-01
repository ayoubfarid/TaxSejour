package com.gestionhotel.sejour.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
public class Secteur implements Serializable {

	private static final long serialVersionUID = 1L; 
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private String nomSecteur;
	@OneToMany(mappedBy = "secteur")
	@JsonProperty(access = Access.READ_WRITE)
	private List<Locale> locales = new ArrayList<Locale>(); 
	@OneToMany
	private List<Quartier> quatriers = new ArrayList<Quartier>(); 
	
	
	
	public List<Quartier> getQuatriers() {
		return quatriers;
	}
	public void setQuatriers(List<Quartier> quatrier) {
		this.quatriers = quatrier;
	}
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
	public String getNomSecteur() {
		return nomSecteur;
	}
	public void setNomSecteur(String nomSecteur) {
		this.nomSecteur = nomSecteur;
	}
	
	public List<Locale> getLocales() {
		return locales;
	}
	public void setLocales(List<Locale> locales) {
		this.locales = locales;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
