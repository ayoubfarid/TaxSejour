package com.gestionhotel.sejour.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gestionhotel.sejour.bean.Locale;

@Repository
public interface LocaleDao extends JpaRepository<Locale,Long>{
	
	public Locale findByRef(String ref);
	public Locale findByRedevable(String refRedevable);
	public Locale findByCategorie(String refCategorie);
	
}
