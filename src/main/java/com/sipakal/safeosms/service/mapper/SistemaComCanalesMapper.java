package com.sipakal.safeosms.service.mapper;

import com.sipakal.safeosms.domain.*;
import com.sipakal.safeosms.service.dto.SistemaComCanalesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity SistemaComCanales and its DTO SistemaComCanalesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SistemaComCanalesMapper extends EntityMapper<SistemaComCanalesDTO, SistemaComCanales> {



    default SistemaComCanales fromId(Long id) {
        if (id == null) {
            return null;
        }
        SistemaComCanales sistemaComCanales = new SistemaComCanales();
        sistemaComCanales.setId(id);
        return sistemaComCanales;
    }
}
