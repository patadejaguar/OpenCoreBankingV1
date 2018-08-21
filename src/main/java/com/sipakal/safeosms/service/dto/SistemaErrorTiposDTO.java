package com.sipakal.safeosms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SistemaErrorTipos entity.
 */
public class SistemaErrorTiposDTO implements Serializable {

    private Long id;

    @Size(max = 80)
    private String errorTiposNom;

    @Size(max = 30)
    private String errorTiposAlias;

    @Max(value = 9)
    private Integer estatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getErrorTiposNom() {
        return errorTiposNom;
    }

    public void setErrorTiposNom(String errorTiposNom) {
        this.errorTiposNom = errorTiposNom;
    }

    public String getErrorTiposAlias() {
        return errorTiposAlias;
    }

    public void setErrorTiposAlias(String errorTiposAlias) {
        this.errorTiposAlias = errorTiposAlias;
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

        SistemaErrorTiposDTO sistemaErrorTiposDTO = (SistemaErrorTiposDTO) o;
        if(sistemaErrorTiposDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaErrorTiposDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaErrorTiposDTO{" +
            "id=" + getId() +
            ", errorTiposNom='" + getErrorTiposNom() + "'" +
            ", errorTiposAlias='" + getErrorTiposAlias() + "'" +
            ", estatus=" + getEstatus() +
            "}";
    }
}
