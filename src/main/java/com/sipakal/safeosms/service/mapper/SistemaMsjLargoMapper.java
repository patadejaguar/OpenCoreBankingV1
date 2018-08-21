package com.sipakal.safeosms.service.mapper;

import com.sipakal.safeosms.domain.*;
import com.sipakal.safeosms.service.dto.SistemaMsjLargoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity SistemaMsjLargo and its DTO SistemaMsjLargoDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SistemaMsjLargoMapper extends EntityMapper<SistemaMsjLargoDTO, SistemaMsjLargo> {



    default SistemaMsjLargo fromId(Long id) {
        if (id == null) {
            return null;
        }
        SistemaMsjLargo sistemaMsjLargo = new SistemaMsjLargo();
        sistemaMsjLargo.setId(id);
        return sistemaMsjLargo;
    }
}
