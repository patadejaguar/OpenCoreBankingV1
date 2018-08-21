package com.sipakal.safeosms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SistemaMsjLargo entity.
 */
public class SistemaMsjLargoDTO implements Serializable {

    private Long id;

    @Size(max = 80)
    private String msjLargoNom;

    @Size(max = 150)
    private String msjLargoTexto;

    @Max(value = 9)
    private Integer estatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsjLargoNom() {
        return msjLargoNom;
    }

    public void setMsjLargoNom(String msjLargoNom) {
        this.msjLargoNom = msjLargoNom;
    }

    public String getMsjLargoTexto() {
        return msjLargoTexto;
    }

    public void setMsjLargoTexto(String msjLargoTexto) {
        this.msjLargoTexto = msjLargoTexto;
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

        SistemaMsjLargoDTO sistemaMsjLargoDTO = (SistemaMsjLargoDTO) o;
        if(sistemaMsjLargoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaMsjLargoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaMsjLargoDTO{" +
            "id=" + getId() +
            ", msjLargoNom='" + getMsjLargoNom() + "'" +
            ", msjLargoTexto='" + getMsjLargoTexto() + "'" +
            ", estatus=" + getEstatus() +
            "}";
    }
}
