package com.sipakal.safeosms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SistemaConfiguracion entity.
 */
public class SistemaConfiguracionDTO implements Serializable {

    private Long id;

    @Size(max = 80)
    private String configuracionNom;

    @Size(max = 15)
    private String configuracionTipo;

    @Size(max = 100)
    private String configuracionVal;

    @Max(value = 9)
    private Integer estatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfiguracionNom() {
        return configuracionNom;
    }

    public void setConfiguracionNom(String configuracionNom) {
        this.configuracionNom = configuracionNom;
    }

    public String getConfiguracionTipo() {
        return configuracionTipo;
    }

    public void setConfiguracionTipo(String configuracionTipo) {
        this.configuracionTipo = configuracionTipo;
    }

    public String getConfiguracionVal() {
        return configuracionVal;
    }

    public void setConfiguracionVal(String configuracionVal) {
        this.configuracionVal = configuracionVal;
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

        SistemaConfiguracionDTO sistemaConfiguracionDTO = (SistemaConfiguracionDTO) o;
        if(sistemaConfiguracionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaConfiguracionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaConfiguracionDTO{" +
            "id=" + getId() +
            ", configuracionNom='" + getConfiguracionNom() + "'" +
            ", configuracionTipo='" + getConfiguracionTipo() + "'" +
            ", configuracionVal='" + getConfiguracionVal() + "'" +
            ", estatus=" + getEstatus() +
            "}";
    }
}
