package com.sipakal.safeosms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SistemaRoles entity.
 */
public class SistemaRolesDTO implements Serializable {

    private Long id;

    private Integer rolesid;

    private Integer tipoEnSistemaid;

    @Max(value = 9)
    private Integer estatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRolesid() {
        return rolesid;
    }

    public void setRolesid(Integer rolesid) {
        this.rolesid = rolesid;
    }

    public Integer getTipoEnSistemaid() {
        return tipoEnSistemaid;
    }

    public void setTipoEnSistemaid(Integer tipoEnSistemaid) {
        this.tipoEnSistemaid = tipoEnSistemaid;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SistemaRolesDTO sistemaRolesDTO = (SistemaRolesDTO) o;
        if(sistemaRolesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaRolesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaRolesDTO{" +
            "id=" + getId() +
            ", rolesid=" + getRolesid() +
            ", tipoEnSistemaid=" + getTipoEnSistemaid() +
            ", estatus=" + getEstatus() +
            "}";
    }
}
