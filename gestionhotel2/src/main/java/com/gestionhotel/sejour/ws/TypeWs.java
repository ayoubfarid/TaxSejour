package com.gestionhotel.sejour.ws;

import com.gestionhotel.sejour.bean.TypeRedevable;
import com.gestionhotel.sejour.service.TypeRedev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeWs {
    @Autowired
    TypeRedev typeRedev;
    @GetMapping("  /")
    public String findByNomType(String code) {
        return typeRedev.findByNomType(code);
    }
    public int countByNomType(String nt) {
        return typeRedev.countByNomType(nt);
    }
    public String findByLibelle(String le) {
        return typeRedev.findByLibelle(le);
    }
    public TypeRedevable deleteByNomType(String s) {
        return typeRedev.deleteByNomType(s);
    }
}
