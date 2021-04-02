package com.gestionhotel.sejour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.bean.TauTaxeSejour;
import com.gestionhotel.sejour.dao.CategorieDao;

@Service
public class CategorieService {
    @Autowired
    CategorieDao categorieDao;
  
	@Autowired
    TauTaxeSejourService tautaxesejourservice;

    public List<Categorie> findAll() {
		return categorieDao.findAll();
	}
    
    public Categorie findByRef(String r) {
  		return categorieDao.findByRef(r);
  	}

	public int  save(String ref,String libelle,List<TauTaxeSejour> tautaxesejours){
		Categorie categorie= new Categorie();
		categorie.setRef(ref);
		categorie.setLibelle(libelle);
		if( findByRef(categorie.getRef()) != null )
		{
			return -1;
		}
		if( tautaxesejours == null )
		{
			return -2;
		}
		else {
			categorieDao.save(categorie);
		for(TauTaxeSejour tautaxesejour:tautaxesejours)
		{
			tautaxesejour.setCategorie(categorie);
			tautaxesejourservice.save(tautaxesejour);			
			
		}
		
		/*for(TauTaxeSejour t:tautaxesejours)
		{
			categorie.getTautaxsejours().add(t);
		}*/
		categorieDao.save(categorie);
		return 1;
		}
		
		
		
		
		
        /*if(categorieDao.countByRef(categorie.getRef())==0){
        	categorieDao.save(categorie);
            return "la Categorie est save";
        }
        else{
            return "la Categorie est deja existe";
        }*/
    }
   /* public boolean cateVr(Categorie categorie){
        if(categorieDao.countByRef(categorie.getRef())>0)
            return true;
        else
            return false;
   }
    public Categorie find(String r) {
        return findByRef(r);
    }
	*/
    /*public Categorie findByLibelleC(String l) {
        return categorieDao.findByLibelle(l);
    }

    public int countByRefC(String ref) {
        return categorieDao.countByRef(ref);
    }*/
}
