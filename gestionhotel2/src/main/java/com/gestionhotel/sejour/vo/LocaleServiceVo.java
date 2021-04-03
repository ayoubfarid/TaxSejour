package com.gestionhotel.sejour.vo;

import java.util.List;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Quartier;

public interface LocaleServiceVo {
	public int save(Quartier quartier,List<Locale> locales);
}
