package com.gestionhotel.sejour.bean;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private Secteur secteur;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Quartier quartier;
	
	public Quartier getQuartier() {
		return quartier;}
	
	@OneToMany(mappedBy = "locale")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<TaxeSejour> taxessejour;

	public List<TaxeSejour> getTaxessejour() {
		return taxessejour;
	}

	public void setTaxessejour(List<TaxeSejour> taxessejour) {
		this.taxessejour = taxessejour;
	}

	public Secteur getSecteur() {
		return this.secteur;
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


@Autowired 
	CategorieService categorieservice;
	public int save(Locale locale) {
		Locale monlocale = findByReference(locale.getReference());
		Redevable redevable = redevableservice.findByRef(locale.getRedevable().getRef()) ;
		Categorie categorie = categorieservice.findByRef(locale.getCategorie().getRef()) ;
		Quartier quartier = quartierService.findByReference(locale.getQuartier().getReference());
		List<Locale> listlocales = localeService.findByQuartierReference(locale.getQuartier().getReference());

		if (redevable == null && categorie == null && quartier == null) {
			return -1;
		}
		else{
			int result = 1;
			for (Locale locales : listlocales) {
				if(locales.getReference().equals(locale.getReference())) {
					result = -1;
				}
			}if(result == -1) return -2;
			else{
				locale.setRedevable(redevable);
				locale.setCategorie(categorie);
				locale.setQuartier(quartier);
				localeDao.save(locale);
				return 1;
			}
		}
	}
	 
	 */
	
}
