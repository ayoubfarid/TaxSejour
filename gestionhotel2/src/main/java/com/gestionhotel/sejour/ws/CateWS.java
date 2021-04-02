package com.gestionhotel.sejour.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.bean.TauTaxeSejour;
import com.gestionhotel.sejour.service.CategorieService;
@RestController
@CrossOrigin( origins = {"http://localhost:4200"} )
@RequestMapping("/redevable/categorie")
public class CateWS {
    @Autowired
    CategorieService categorieService;
    
    @GetMapping("/")
    public List<Categorie> findAll() {
		return categorieService.findAll();
	}
	@PostMapping("/")
    public int save(@RequestBody Categorie categorie) {
        return categorieService.save(categorie.getRef(),categorie.getLibelle(),categorie.getTautaxsejours());
    }
    @GetMapping("/ref/{ref}")
    public Categorie findByRef(@PathVariable String ref) {
        return categorieService.findByRef(ref);
    }
    /*
    @GetMapping("/Categorie/libellecate/{label}")
    public Categorie findByLibelleCate(@PathVariable String l) {
        return categorieService.findByLibelleC(l);
    }
    @GetMapping("/Categorie/countByref/{ref}")
    public int countByRefC(@PathVariable String ref) {
        return categorieService.countByRefC(ref);
    }*/
}
