package com.sipakal.safeosms.service.mapper;

import com.sipakal.safeosms.domain.*;
import com.sipakal.safeosms.service.dto.SistemaLenguajeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity SistemaLenguaje and its DTO SistemaLenguajeDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SistemaLenguajeMapper extends EntityMapper<SistemaLenguajeDTO, SistemaLenguaje> {



    default SistemaLenguaje fromId(Long id) {
        if (id == null) {
            return null;
        }
        SistemaLenguaje sistemaLenguaje = new SistemaLenguaje();
        sistemaLenguaje.setId(id);
        return sistemaLenguaje;
    }
}
