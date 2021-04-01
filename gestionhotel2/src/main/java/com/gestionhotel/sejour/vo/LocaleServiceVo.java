package com.gestionhotel.sejour.vo;

import java.util.List;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Secteur;

public interface LocaleServiceVo {

	public int save(Secteur secteur,List<Locale> locales);
}
