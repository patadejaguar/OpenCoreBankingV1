package com.sipakal.safeosms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SistemaNivelRiesgo entity.
 */
public class SistemaNivelRiesgoDTO implements Serializable {

    private Long id;

    @Size(max = 80)
    private String nivelRiesgoNom;

    @Size(max = 30)
    private String nivelRiesgoAlias;

    @Max(value = 9)
    private Integer estatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNivelRiesgoNom() {
        return nivelRiesgoNom;
    }

    public void setNivelRiesgoNom(String nivelRiesgoNom) {
        this.nivelRiesgoNom = nivelRiesgoNom;
    }

    public String getNivelRiesgoAlias() {
        return nivelRiesgoAlias;
    }

    public void setNivelRiesgoAlias(String nivelRiesgoAlias) {
        this.nivelRiesgoAlias = nivelRiesgoAlias;
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

        SistemaNivelRiesgoDTO sistemaNivelRiesgoDTO = (SistemaNivelRiesgoDTO) o;
        if(sistemaNivelRiesgoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaNivelRiesgoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaNivelRiesgoDTO{" +
            "id=" + getId() +
            ", nivelRiesgoNom='" + getNivelRiesgoNom() + "'" +
            ", nivelRiesgoAlias='" + getNivelRiesgoAlias() + "'" +
            ", estatus=" + getEstatus() +
            "}";
    }
}
