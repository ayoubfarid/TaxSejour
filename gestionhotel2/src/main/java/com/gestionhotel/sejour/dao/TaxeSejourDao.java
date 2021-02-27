package com.example.j2ee.projet1.Dao;
import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.j2ee.projet1.bean.TaxeSejour;
 @Repository 
public interface  TaxeSejourDao extends JpaRepository<TaxeSejour,Long>{
	 //un redevable peut avoir plusieurs locaux
	public List<TaxeSejour>  findByRefRedevable(String refedevable);
	// on peut pas calculer le taxe sejour plus que 1 fois par  trim de chque annee
	 public   TaxeSejour findByAnneeAndReflocaleAndTrimAndRefRedevable(int annee,String locale,int trim,String red);
	 // chaque trim de chaque annee on doit payer le montant 
	public List<TaxeSejour> findByReflocale(String locale);
	// un locale doit avoir un seul redevable pour chaque locale
	public TaxeSejour findByRefRedevableAndReflocale(String red,String locale);
	//
	public   TaxeSejour findByAnneeAndReflocaleAndMontantNuiteAndTrim(int annee,String locale,double montant,int trimestre);
	public  List<TaxeSejour>findAll();
	 
}
