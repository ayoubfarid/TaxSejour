package com.gestionhotel.sejour.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class TypeRedevable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomType;
	private String libelle;
	public TypeRedevable(String name ,String lib){
		this.nomType=name;
		this.libelle=lib;
	}
	public TypeRedevable() {

	}
	public String getNomType() {
		return nomType;
	}
	public void setnameType(String nomType) {
		this.nomType = nomType;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
