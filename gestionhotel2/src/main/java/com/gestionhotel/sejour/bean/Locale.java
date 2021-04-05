package com.gestionhotel.sejour.bean;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Locale implements Serializable {

	private static final long serialVersionUID = 1L; 
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String reference;
	@ManyToOne
	private Redevable redevable;
	@ManyToOne
	private Categorie categorie;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Quartier quartier;
	
	public Quartier getQuartier() {
		return quartier;
	}
	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locale other = (Locale) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public void setReference(String ref) {
		this.reference = ref;
	}

	public Redevable getRedevable() {
		return redevable;
	}
	public void setRedevable(Redevable redevable) {
		this.redevable = redevable;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
	/*
	 * 
{
  "categorie": {
    "ref": "cat3"
  },
  "quartier": {
    "reference": "q1",
    "secteur": {
      "reference": "s2"
    }
  },
  "redevable": {
    "ref": "r2"
  },
  "reference": "l4"
}
	 
	 */
	
}
