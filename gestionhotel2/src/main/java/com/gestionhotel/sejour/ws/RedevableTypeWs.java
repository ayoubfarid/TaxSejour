package com.gestionhotel.sejour.ws;

import com.gestionhotel.sejour.bean.RedevableType;
import com.gestionhotel.sejour.service.TypeRedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redevable/type")

public class RedevableTypeWs {
    @Autowired
    TypeRedevableService typeRedevableService;
    @PostMapping("/")

    public int save(@RequestBody RedevableType type) {
        return typeRedevableService.save(type);
    }
    @GetMapping("/findByCode{name}")
    public RedevableType findByCode(@PathVariable String name) {
        return typeRedevableService.findByNomType(name);
    }
    @GetMapping("/findbylibelle{libbelle}")
    public String findByLibelle(@PathVariable String libbelle) {
        return typeRedevableService.findByLibelle(libbelle);
    }
}
