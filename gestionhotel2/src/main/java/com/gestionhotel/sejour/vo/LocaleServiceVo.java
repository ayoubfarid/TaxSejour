package com.gestionhotel.sejour.vo;

import java.util.List;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.bean.TaxeSejour;

public interface LocaleServiceVo {

	public int save(Secteur secteur,List<Locale> locales);
	public int save(String ref,String red,String ca,String sec , List<TaxeSejour> taxessejour);
}
