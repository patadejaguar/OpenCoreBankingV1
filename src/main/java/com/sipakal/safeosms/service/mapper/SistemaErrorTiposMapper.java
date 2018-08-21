package com.sipakal.safeosms.service.mapper;

import com.sipakal.safeosms.domain.*;
import com.sipakal.safeosms.service.dto.SistemaErrorTiposDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity SistemaErrorTipos and its DTO SistemaErrorTiposDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SistemaErrorTiposMapper extends EntityMapper<SistemaErrorTiposDTO, SistemaErrorTipos> {



    default SistemaErrorTipos fromId(Long id) {
        if (id == null) {
            return null;
        }
        SistemaErrorTipos sistemaErrorTipos = new SistemaErrorTipos();
        sistemaErrorTipos.setId(id);
        return sistemaErrorTipos;
    }
}
