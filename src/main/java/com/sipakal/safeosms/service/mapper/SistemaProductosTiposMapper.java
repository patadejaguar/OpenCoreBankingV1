package com.sipakal.safeosms.service.mapper;

import com.sipakal.safeosms.domain.*;
import com.sipakal.safeosms.service.dto.SistemaProductosTiposDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity SistemaProductosTipos and its DTO SistemaProductosTiposDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SistemaProductosTiposMapper extends EntityMapper<SistemaProductosTiposDTO, SistemaProductosTipos> {



    default SistemaProductosTipos fromId(Long id) {
        if (id == null) {
            return null;
        }
        SistemaProductosTipos sistemaProductosTipos = new SistemaProductosTipos();
        sistemaProductosTipos.setId(id);
        return sistemaProductosTipos;
    }
}
