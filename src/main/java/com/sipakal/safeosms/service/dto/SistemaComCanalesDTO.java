package com.sipakal.safeosms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SistemaComCanales entity.
 */
public class SistemaComCanalesDTO implements Serializable {

    private Long id;

    @Size(max = 10)
    private String comCanalesNom;

    @Size(max = 30)
    private String comCanalesAlias;

    @Max(value = 9)
    private Integer estatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComCanalesNom() {
        return comCanalesNom;
    }

    public void setComCanalesNom(String comCanalesNom) {
        this.comCanalesNom = comCanalesNom;
    }

    public String getComCanalesAlias() {
        return comCanalesAlias;
    }

    public void setComCanalesAlias(String comCanalesAlias) {
        this.comCanalesAlias = comCanalesAlias;
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

        SistemaComCanalesDTO sistemaComCanalesDTO = (SistemaComCanalesDTO) o;
        if(sistemaComCanalesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaComCanalesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaComCanalesDTO{" +
            "id=" + getId() +
            ", comCanalesNom='" + getComCanalesNom() + "'" +
            ", comCanalesAlias='" + getComCanalesAlias() + "'" +
            ", estatus=" + getEstatus() +
            "}";
    }
}
