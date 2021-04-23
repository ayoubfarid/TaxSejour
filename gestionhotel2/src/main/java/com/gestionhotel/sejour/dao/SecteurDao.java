package com.gestionhotel.sejour.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionhotel.sejour.bean.Secteur;

@Repository
public interface SecteurDao extends JpaRepository<Secteur,Long>{
	
	public Secteur findByReference(String ref);
	public int deleteByReference(String ref);
	public List<Secteur> findAll();
	
	
}
