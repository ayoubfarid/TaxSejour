package com.gestionhotel.sejour.ws;

import java.util.List;

import com.gestionhotel.sejour.vo.TaxeSejourVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gestionhotel.sejour.bean.TaxeSejour;
import com.gestionhotel.sejour.service.TaxeSejoureService;


@RestController
@RequestMapping("gestiontaxesejour/taxesejour")
@CrossOrigin(origins ={"http://localhost:4200"})
public class TaxeSejourRest {
	
	@Autowired
	TaxeSejoureService taxesejourservice;
	@GetMapping("/referencelocale/{reference}")
	 public	List<TaxeSejour> findByLocaleReference(@PathVariable String reference){
		return  taxesejourservice.findByLocaleReference(reference);
	 }
	@GetMapping("/referenceredevable/{reference}")
public List<TaxeSejour> findByRedevableRef(@PathVariable String reference) {
		return taxesejourservice.findByRedevableRef(reference);
	}
	@GetMapping("/referenceredevable/{refredevable}/referencelocale/{reflocale}")
	public  List<TaxeSejour> findByRedevableReferenceAndLocaleReference(@PathVariable String refredevable, @PathVariable String reflocale) {
		return taxesejourservice.findByRedevableRefAndLocaleReference(refredevable, reflocale);
	}
	@GetMapping("/annee/{annee}/reerencelocale/{locale}/trimestre/trim/referenceredevable/{red}")
	public TaxeSejour findByAnneeAndLocaleReferenceerenceAndTrimAndRedevableRef(@PathVariable int annee, @PathVariable String locale,@PathVariable int trim,@PathVariable String red) {
		return taxesejourservice.findByAnneeAndLocaleReferenceAndTrimAndRedevableRef(annee, locale, trim, red);
	}
	
	@DeleteMapping("/redevable/{s}")
 public int deleteByRedevableRef(@PathVariable String s) {
		return taxesejourservice.deleteByRedevableRef(s);
	}
 @DeleteMapping("/locale/{loca}")
	public int deleteByLocaleRef(@PathVariable String loca) {
		return taxesejourservice.deleteByLocaleReference(loca);
	}
@DeleteMapping("/redevable/{red}/locale/{loca}")
public int deleteByRedevableRefAndLocaleReference(@PathVariable String red,@PathVariable String loca) {
		return taxesejourservice.deleteByRedevableRefAndLocaleReference(red, loca);
	}
 @GetMapping("/recherche-par-an/{an}")
public List<TaxeSejour> findByAnneespecifique(@PathVariable int an) {
	return taxesejourservice.findByAnneespecifique(an);
}
@PostMapping("/")
	public int save( @RequestBody  TaxeSejour s) {
		return taxesejourservice.save(s);
	}
	public int hashCode() {
		return taxesejourservice.hashCode();
	}

	public boolean equals(Object obj) {
		return taxesejourservice.equals(obj);
	}

	public String toString() {
		return taxesejourservice.toString();
	}
	@PostMapping("/trimestre")
	public List<TaxeSejourVo> findByTrimestre(@RequestBody TaxeSejourVo vo) {
		return taxesejourservice.findByTrimestre(vo);
	}

}


