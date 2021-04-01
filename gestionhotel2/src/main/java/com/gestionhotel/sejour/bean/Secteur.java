package com.gestionhotel.sejour.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Secteur implements Serializable {

	private static final long serialVersionUID = 1L; 
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private String nomSecteur;
	@OneToMany
	private Locale locale;
	@OneToMany
	private List<Quartier> quatrier; 
	
	
	
	public List<Quartier> getQuatries() {
		return quatrier;
	}
	public void setQuatries(List<Quartier> quatrier) {
		this.quatrier = quatrier;
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
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
