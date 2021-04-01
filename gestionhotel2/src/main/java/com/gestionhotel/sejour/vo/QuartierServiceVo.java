package com.gestionhotel.sejour.vo;


import java.util.List;

import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Secteur;

public interface QuartierServiceVo{
	
	public int save(Secteur secteur,List<Quartier> quartiers);
	
	
}
