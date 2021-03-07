package com.gestionhotel.sejour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.bean.TauTaxeSejour;
import com.gestionhotel.sejour.dao.TauTaxeSejourDao;

@Service
public class TauTaxeSejourService {
	@Autowired
	private TauTaxeSejourDao tautaxesejourdao;
	
	
	
	public List<TauTaxeSejour> findByMontantNuiteSuperieur(double montant) {
		return tautaxesejourdao.findByMontantNuiteSuperieur(montant);
	}



	@Autowired
	private CategorieService categorieservice;
	
	
	public TauTaxeSejour findByMontantNuite(double montant) {
		return tautaxesejourdao.findByMontantNuite(montant);
	}



	public TauTaxeSejour findByCategorieRef(String ref) {
		return tautaxesejourdao.findByCategorieRef(ref);
	}
	
	


	public List <TauTaxeSejour> findAll() {
		return tautaxesejourdao.findAll();
	}

	

	public int save(TauTaxeSejour tautaxesejour) {
		
		if (findByCategorieRef(tautaxesejour.getCategorie().getRef())!= null)
		{
			return -1;
		}else {
			Categorie categorie = categorieservice.cateDao.findByRef(tautaxesejour.getCategorie().getRef());
			tautaxesejour.setCategorie(categorie);
			
			tautaxesejourdao.save(tautaxesejour);
			return 1;
		}
		
	
	}
	
	
}
