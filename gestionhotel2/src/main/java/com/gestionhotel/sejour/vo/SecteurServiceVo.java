package com.gestionhotel.sejour.vo;


import com.gestionhotel.sejour.bean.Secteur;

public interface SecteurServiceVo  {

	public Secteur findByReference(String ref);
	public int deleteByReference(String ref);
	public int save(Secteur secteur);
	public int updating(Secteur secteur);
}
