package com.gestionhotel.sejour.ws;

import com.gestionhotel.sejour.bean.Locale;
import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.converter.Converter;
import com.gestionhotel.sejour.service.RedevableService;
import com.gestionhotel.sejour.vo.RedevableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/app-redevable")
public class RedevableWS {
    @Autowired
    RedevableService redevableService;

    @Autowired
    Converter converter;

    @GetMapping("/")
    public List<RedevableVo> findAll() {
        return converter.convertRedevableList(redevableService.findAll());
    }

    @PostMapping("/")
    public int Save(@RequestBody RedevableVo redevableVo) {
        return redevableService.save(converter.convertRedevable(redevableVo));
    }

    @GetMapping("/Redvable/{ref}")
    public Redevable findByRef(@PathVariable String ref) {
        return redevableService.findByRef(ref);
    }

    @GetMapping("/Redvable/{Type}")
    public List<Redevable> findByType(@PathVariable String type) {
        return redevableService.findByType(type);
    }

    @PutMapping("/")
    public int edit(@RequestBody RedevableVo redevableVo) {
        return redevableService.edit(converter.convertRedevable(redevableVo));
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return redevableService.deleteByRef(ref);
    }
}
