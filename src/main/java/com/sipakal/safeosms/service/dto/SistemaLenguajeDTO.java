package com.sipakal.safeosms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SistemaLenguaje entity.
 */
public class SistemaLenguajeDTO implements Serializable {

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

        SistemaLenguajeDTO sistemaLenguajeDTO = (SistemaLenguajeDTO) o;
        if(sistemaLenguajeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaLenguajeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaLenguajeDTO{" +
            "id=" + getId() +
            ", lenguajeID='" + getLenguajeID() + "'" +
            ", lenguajeVal='" + getLenguajeVal() + "'" +
            "}";
    }
}
