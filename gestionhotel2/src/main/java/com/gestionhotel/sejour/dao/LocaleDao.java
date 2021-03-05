package com.gestionhotel.sejour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionhotel.sejour.bean.Locale;

@Repository
public interface LocaleDao extends JpaRepository<Locale,Long>{
	
	public Locale findByRef(String ref);
	public int deleteByRef(String ref);
	public List<Locale> findByRedevable(String refRedevable);
	public List<Locale> findByCategorieRef(String refCategorie);
	public int deleteByRedevableRef(String s);
}
