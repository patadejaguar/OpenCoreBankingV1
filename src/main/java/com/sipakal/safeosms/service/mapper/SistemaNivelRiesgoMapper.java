package com.sipakal.safeosms.service.mapper;

import com.sipakal.safeosms.domain.*;
import com.sipakal.safeosms.service.dto.SistemaNivelRiesgoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity SistemaNivelRiesgo and its DTO SistemaNivelRiesgoDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SistemaNivelRiesgoMapper extends EntityMapper<SistemaNivelRiesgoDTO, SistemaNivelRiesgo> {



    default SistemaNivelRiesgo fromId(Long id) {
        if (id == null) {
            return null;
        }
        SistemaNivelRiesgo sistemaNivelRiesgo = new SistemaNivelRiesgo();
        sistemaNivelRiesgo.setId(id);
        return sistemaNivelRiesgo;
    }
}
