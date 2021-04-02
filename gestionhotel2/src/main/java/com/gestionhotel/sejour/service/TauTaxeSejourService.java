package com.gestionhotel.sejour.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.bean.TauTaxeSejour;
import com.gestionhotel.sejour.dao.TauTaxeSejourDao;
import com.gestionhotel.sejour.vo.TauTaxSejourVo;

@Service
public class TauTaxeSejourService {
	@Autowired
	private TauTaxeSejourDao tautaxesejourdao;
	


	@Autowired 
	EntityManager entitymanager;
	
	
	public Optional<TauTaxeSejour> findById(Long id) {
		return tautaxesejourdao.findById(id);
	}
	
	
	
	public int updateById(TauTaxeSejour tautaxesejour) {
		Categorie categorie = categorieservice.findByRef(tautaxesejour.getCategorie().getRef());
		tautaxesejour.setCategorie(categorie);
			
			tautaxesejourdao.save(tautaxesejour);
			return 1;
		
		
	}
	
	
	@Transactional
	public void deleteById(Long id) {
		
		tautaxesejourdao.deleteById(id);
		
	}

	public List<TauTaxeSejour> findByMontantNuiteSuperieur(double montant) {
		return tautaxesejourdao.findByMontantNuiteSuperieur(montant);
	}

	@SuppressWarnings("unchecked")
	public List<TauTaxeSejour> searchByCriteria(TauTaxSejourVo tautaxesejourvo)
	{
			String query ="SELECT t FROM TauTaxeSjour t where 1=1";
			/*if ( tautaxesejourvo.getId() != null  )
				query+=" And t.id like "+tautaxesejourvo.getId()+" ";*/
			if ( tautaxesejourvo.getMontantNuiteMin() !=  null  )
				query+=" And t.montantnuite >= "+tautaxesejourvo.getMontantNuiteMin()+" ";
			if ( tautaxesejourvo.getMontantNuiteMax() !=  null  )
				query+=" And t.montantnuite <= "+tautaxesejourvo.getMontantNuiteMax()+" ";
		
			return entitymanager.createQuery(query).getResultList() ;
		
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
		
			Categorie categorie = categorieservice.findByRef(tautaxesejour.getCategorie().getRef());
			tautaxesejour.setCategorie(categorie);
			
			tautaxesejourdao.save(tautaxesejour);
			return 1;
		
		
	
	}
	
	
}
