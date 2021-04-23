package com.gestionhotel.sejour.vo;


import java.util.List;


import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Secteur;

public interface QuartierServiceVo{
	
	public int deleteBySecteurReference(String ref);
	public List<Quartier> findBySecteurReference(String ref);
	public int save(Secteur secteur,List<Quartier> quartiers);
	public int updateQuartier(Quartier quartier);
	
	
}
