package com.gestionhotel.sejour.ws;

import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.service.CategorieService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/redevable/cate")
public class CateWS {
    @Autowired
    CategorieService cateService;
    
    @GetMapping("/Categorie")
    public List<Categorie> findAll() {
		return cateService.findAll();
	}
	@PostMapping("/Categorie")
    public String saveCate(@RequestBody Categorie categorie) {
        return cateService.saveCate(categorie);
    }
    @GetMapping("/Categorie/ref/{ref}")
    public Categorie find(@PathVariable String r) {
        return cateService.find(r);
    }
    @GetMapping("/Categorie/libellecate/{label}")
    public Categorie findByLibelleCate(@PathVariable String l) {
        return cateService.findByLibelleC(l);
    }
    @GetMapping("/Categorie/countByref/{ref}")
    public int countByRefC(@PathVariable String ref) {
        return cateService.countByRefC(ref);
    }
}
