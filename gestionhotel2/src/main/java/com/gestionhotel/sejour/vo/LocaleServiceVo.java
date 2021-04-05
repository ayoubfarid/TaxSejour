package com.gestionhotel.sejour.vo;

import java.util.List;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Quartier;
import com.gestionhotel.sejour.bean.Secteur;
import com.gestionhotel.sejour.bean.TaxeSejour;

public interface LocaleServiceVo {
	public int save(Quartier quartier,List<Locale> locales);
}
