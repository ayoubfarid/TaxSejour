package com.gestionhotel.sejour.ws;

import com.gestionhotel.sejour.bean.TypeRedevable;
import com.gestionhotel.sejour.service.TypeRedevServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeWs {
    @Autowired
    TypeRedevServ typeRedevServ;
    @GetMapping("  /")
    public String findByNomType(String code) {
        return typeRedevServ.findByNomType(code);
    }
    public int countByNomType(String nt) {
        return typeRedevServ.countByNomType(nt);
    }
    public String findByLibelle(String le) {
        return typeRedevServ.findByLibelle(le);
    }
    public TypeRedevable deleteByNomType(String s) {
        return typeRedevServ.deleteByNomType(s);
    }
}
