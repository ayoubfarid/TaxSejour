package com.gestionhotel.sejour.ws;

import com.gestionhotel.sejour.bean.Categorie;
import com.gestionhotel.sejour.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CateWS {
    @Autowired
    CateService cateService;
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
