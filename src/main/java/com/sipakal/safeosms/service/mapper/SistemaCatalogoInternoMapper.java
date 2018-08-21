package com.sipakal.safeosms.service.mapper;

import com.sipakal.safeosms.domain.*;
import com.sipakal.safeosms.service.dto.SistemaCatalogoInternoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity SistemaCatalogoInterno and its DTO SistemaCatalogoInternoDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SistemaCatalogoInternoMapper extends EntityMapper<SistemaCatalogoInternoDTO, SistemaCatalogoInterno> {



    default SistemaCatalogoInterno fromId(Long id) {
        if (id == null) {
            return null;
        }
        SistemaCatalogoInterno sistemaCatalogoInterno = new SistemaCatalogoInterno();
        sistemaCatalogoInterno.setId(id);
        return sistemaCatalogoInterno;
    }
}
