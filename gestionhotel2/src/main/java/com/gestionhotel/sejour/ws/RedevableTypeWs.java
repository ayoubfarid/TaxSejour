package com.gestionhotel.sejour.ws;

import com.gestionhotel.sejour.bean.RedevableType;
import com.gestionhotel.sejour.converter.Converter;
import com.gestionhotel.sejour.service.RedevableTypeService;
import com.gestionhotel.sejour.vo.RedevableTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/app-redevable/type")

public class RedevableTypeWs {
    @Autowired
    RedevableTypeService redevableTypeService;
    @Autowired
    Converter converter;
    @PostMapping("/")
    public int save(@RequestBody RedevableTypeVo type) {
        return redevableTypeService.save(converter.convertType(type));
    }

    @PutMapping("/edit/")
    public int edit(@RequestBody RedevableTypeVo typeVo) {
        return redevableTypeService.edit(converter.convertType(typeVo));
    }

    @GetMapping("/")
    public List<RedevableTypeVo> findAll() {
        return converter.convertTypeList( redevableTypeService.findAll());
    }
    @GetMapping("/code/{code}")
    public int findCode(String code) {
        return redevableTypeService.findcode(code);
    }

    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return redevableTypeService.deleteByLibelle(libelle);
    }
}
