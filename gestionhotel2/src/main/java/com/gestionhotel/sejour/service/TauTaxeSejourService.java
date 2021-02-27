package com.gestionhotel.sejour.service;

import java.util.List;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhotel.sejour.bean.TauTaxeSejour;
import com.gestionhotel.sejour.dao.TauTaxeSejourDao;

@Service
public class TauTaxeSejourService {
	@Autowired
	private TauTaxeSejourDao tautaxesejourdao;

	public List <TauTaxeSejour> findByRefCategorie(String RefCategorie) {
		return tautaxesejourdao.findByRefCategorie(RefCategorie);
	}

	/*public List <TauTaxeSejour> findByCat(String cat) {
		return tautaxesejourdao.findByCat(cat);
	}*/

	public List <TauTaxeSejour> findAll() {
		return tautaxesejourdao.findAll();
	}

	

	public int save(TauTaxeSejour tautaxesejour) {
		if (findByRefCategorie(tautaxesejour.getRefCategorie())!= null)
		{
			return -1;
		}else {
			tautaxesejourdao.save(tautaxesejour);
	return 1;
		}
		
	
	}
	
}
