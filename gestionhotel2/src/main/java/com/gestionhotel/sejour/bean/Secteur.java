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
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String reference;
	private String nomSecteur;
	
	@OneToMany(mappedBy = "secteur")
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Secteur other = (Secteur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/*
	 * 
{
  "id": 0,
  "nomSecteur": "sect16",
  "quatriers": [
    {
      
      "num": 15,
      "reference": "q15"
    }
  ],
 "quatriers": [
    {
      
      "num": 150,
      "reference": "q16"
    }
  ],
  "reference": "s16"
}
	 */
}
