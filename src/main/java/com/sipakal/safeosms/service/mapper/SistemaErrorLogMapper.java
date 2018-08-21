package com.sipakal.safeosms.service.mapper;

import com.sipakal.safeosms.domain.*;
import com.sipakal.safeosms.service.dto.SistemaErrorLogDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity SistemaErrorLog and its DTO SistemaErrorLogDTO.
 */
@Mapper(componentModel = "spring", uses = {SistemaErrorTiposMapper.class})
public interface SistemaErrorLogMapper extends EntityMapper<SistemaErrorLogDTO, SistemaErrorLog> {

    @Mapping(source = "errorTiposid.id", target = "errorTiposidId")
    SistemaErrorLogDTO toDto(SistemaErrorLog sistemaErrorLog);

    @Mapping(source = "errorTiposidId", target = "errorTiposid")
    SistemaErrorLog toEntity(SistemaErrorLogDTO sistemaErrorLogDTO);

    default SistemaErrorLog fromId(Long id) {
        if (id == null) {
            return null;
        }
        SistemaErrorLog sistemaErrorLog = new SistemaErrorLog();
        sistemaErrorLog.setId(id);
        return sistemaErrorLog;
    }
}
