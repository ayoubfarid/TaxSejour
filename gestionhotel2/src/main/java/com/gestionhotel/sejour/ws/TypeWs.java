package com.gestionhotel.sejour.ws;

import com.gestionhotel.sejour.bean.TypeRedevable;
import com.gestionhotel.sejour.service.TypeRedevServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redevable/type")

public class TypeWs {
    @Autowired
    TypeRedevServ typeRedevServ;
    @PostMapping("/")

    public int save(@RequestBody TypeRedevable type) {
        return typeRedevServ.save(type);
    }
    @GetMapping("/findbynome{name}")
    public TypeRedevable findByNomType(@PathVariable String name) {
        return typeRedevServ.findByNomType(name);
    }
    @GetMapping("/count{nt}")
    public int countByNomType(@PathVariable String nt) {
        return typeRedevServ.countByNomType(nt);
    }
    @GetMapping("/findbylibelle{name}")
    public String findByLibelle(@PathVariable String le) {
        return typeRedevServ.findByLibelle(le);
    }
}
