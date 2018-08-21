package com.sipakal.safeosms.service.mapper;

import com.sipakal.safeosms.domain.*;
import com.sipakal.safeosms.service.dto.SistemaConfiguracionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity SistemaConfiguracion and its DTO SistemaConfiguracionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SistemaConfiguracionMapper extends EntityMapper<SistemaConfiguracionDTO, SistemaConfiguracion> {



    default SistemaConfiguracion fromId(Long id) {
        if (id == null) {
            return null;
        }
        SistemaConfiguracion sistemaConfiguracion = new SistemaConfiguracion();
        sistemaConfiguracion.setId(id);
        return sistemaConfiguracion;
    }
}
