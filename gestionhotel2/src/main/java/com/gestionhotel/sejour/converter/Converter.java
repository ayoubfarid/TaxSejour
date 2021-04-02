package com.gestionhotel.sejour.converter;

import com.gestionhotel.sejour.bean.Redevable;
import com.gestionhotel.sejour.bean.RedevableType;
import com.gestionhotel.sejour.service.RedevableTypeService;
import com.gestionhotel.sejour.vo.RedevableTypeVo;
import com.gestionhotel.sejour.vo.RedevableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {
    @Autowired
    RedevableTypeService redevableTypeService;

    public Redevable convertRedevable(RedevableVo redevableVo) {
        Redevable redevable = new Redevable();
        redevable.setRef(redevableVo.getRef());
        redevable.setType(redevableTypeService.findByCode(redevableVo.getType()));
        return redevable;
    }

    public RedevableType convertType(RedevableTypeVo redevabletypeVo) {
        RedevableType redevabletype = new RedevableType();
        redevabletype.setCode(redevabletypeVo.getCode());
        redevabletype.setLibelle((redevabletypeVo.getLibelle()));
        return redevabletype;
    }

    public List<RedevableTypeVo> convertTypeList(List<RedevableType> listType) {
        List<RedevableTypeVo> listVo = new ArrayList<RedevableTypeVo>();
        for (int i = 0; i < listType.size(); i++) {
            RedevableTypeVo tmp = new RedevableTypeVo();
            tmp.setCode(listType.get(i).getCode());
            tmp.setLibelle(listType.get(i).getLibelle());
            listVo.add(tmp);
            tmp = null;
        }
        return listVo;
    }
    public List<RedevableVo> convertRedevableList(List<Redevable> listType) {
        List<RedevableVo> listVo = new ArrayList<RedevableVo>();
        for (int i = 0; i < listType.size(); i++) {
            RedevableVo tmp = new RedevableVo();
            tmp.setRef(listType.get(i).getRef());
            tmp.setType(listType.get(i).getType().getCode());
            listVo.add(tmp);
            tmp = null;
        }
        return listVo;
    }


}
