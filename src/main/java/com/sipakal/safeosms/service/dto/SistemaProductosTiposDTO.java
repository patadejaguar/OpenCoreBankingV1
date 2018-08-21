package com.sipakal.safeosms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SistemaProductosTipos entity.
 */
public class SistemaProductosTiposDTO implements Serializable {

    private Long id;

    @Size(max = 30)
    private String lenguajeID;

    @Size(max = 80)
    private String lenguajeVal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLenguajeID() {
        return lenguajeID;
    }

    public void setLenguajeID(String lenguajeID) {
        this.lenguajeID = lenguajeID;
    }

    public String getLenguajeVal() {
        return lenguajeVal;
    }

    public void setLenguajeVal(String lenguajeVal) {
        this.lenguajeVal = lenguajeVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SistemaProductosTiposDTO sistemaProductosTiposDTO = (SistemaProductosTiposDTO) o;
        if(sistemaProductosTiposDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaProductosTiposDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaProductosTiposDTO{" +
            "id=" + getId() +
            ", lenguajeID='" + getLenguajeID() + "'" +
            ", lenguajeVal='" + getLenguajeVal() + "'" +
            "}";
    }
}
