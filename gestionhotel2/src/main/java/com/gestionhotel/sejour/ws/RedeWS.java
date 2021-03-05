package com.gestionhotel.sejour.ws;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.service.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RedeWS {
    @Autowired
    RedevableService redevableService;
    @PostMapping("/Redvable")
    public int SaveRed(@RequestBody Redevable rd) {
        return redevableService.SaveRed(rd);
    }
    @GetMapping("/Redvable/{ref}")
    public Redevable findByRef(@PathVariable String ref) {
        return redevableService.findByRef(ref);
    }
    @GetMapping("/Redvable/{Type}")
    public List<Redevable> findByType(@PathVariable String t) {
        return redevableService.findByType(t);
    }
    @GetMapping("/Redevable/allLocal/{ref}")
    public List<Locale> allLocoleOfRdv(@PathVariable String ref) {
        return redevableService.allLocoleOfRdv(ref);
    }
}
