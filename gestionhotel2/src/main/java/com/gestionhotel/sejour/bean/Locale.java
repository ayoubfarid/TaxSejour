package com.example.projet1.beans;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javassist.SerialVersionUID;

@SuppressWarnings({ "serial", "unused" })
@Entity
public class Locale implements Serializable {

	@SuppressWarnings("unused")
	private static final long SerialVersionUID=1L; 
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ref;
	private String adresse;
	private String rue;
	private String refRedevable;
	private String refCategorie;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getRefRedevable() {
		return refRedevable;
	}
	public void setRefRedevable(String refRedevable) {
		this.refRedevable = refRedevable;
	}
	public String getRefCategorie() {
		return refCategorie;
	}
	public void setRefCategorie(String refCategorie) {
		this.refCategorie = refCategorie;
	}
	
}
