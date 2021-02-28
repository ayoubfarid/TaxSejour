package com.gestionhotel.sejour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projet1.beans.Locale;

@Repository
public interface LocaleDao extends JpaRepository<Locale,Long>{
	
	public Locale findByRef(String ref);
	public List<Locale> findByRefRedevable(String refRedevable);
	public List<Locale> findByRefCategorie(String refCategorie);
	
}
