package com.sipakal.safeosms.service.mapper;

import com.sipakal.safeosms.domain.*;
import com.sipakal.safeosms.service.dto.SistemaRolesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity SistemaRoles and its DTO SistemaRolesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SistemaRolesMapper extends EntityMapper<SistemaRolesDTO, SistemaRoles> {



    default SistemaRoles fromId(Long id) {
        if (id == null) {
            return null;
        }
        SistemaRoles sistemaRoles = new SistemaRoles();
        sistemaRoles.setId(id);
        return sistemaRoles;
    }
}
