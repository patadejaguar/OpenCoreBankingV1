package com.sipakal.safeosms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SistemaCatalogoInterno entity.
 */
public class SistemaCatalogoInternoDTO implements Serializable {

    private Long id;

    @Size(max = 80)
    private String catalogoInternoTbl;

    @Size(max = 80)
    private String catalogoInternoNom;

    @Size(max = 100)
    private String catalogoInternoVal;

    @Max(value = 9)
    private Integer estatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatalogoInternoTbl() {
        return catalogoInternoTbl;
    }

    public void setCatalogoInternoTbl(String catalogoInternoTbl) {
        this.catalogoInternoTbl = catalogoInternoTbl;
    }

    public String getCatalogoInternoNom() {
        return catalogoInternoNom;
    }

    public void setCatalogoInternoNom(String catalogoInternoNom) {
        this.catalogoInternoNom = catalogoInternoNom;
    }

    public String getCatalogoInternoVal() {
        return catalogoInternoVal;
    }

    public void setCatalogoInternoVal(String catalogoInternoVal) {
        this.catalogoInternoVal = catalogoInternoVal;
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

        SistemaCatalogoInternoDTO sistemaCatalogoInternoDTO = (SistemaCatalogoInternoDTO) o;
        if(sistemaCatalogoInternoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaCatalogoInternoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaCatalogoInternoDTO{" +
            "id=" + getId() +
            ", catalogoInternoTbl='" + getCatalogoInternoTbl() + "'" +
            ", catalogoInternoNom='" + getCatalogoInternoNom() + "'" +
            ", catalogoInternoVal='" + getCatalogoInternoVal() + "'" +
            ", estatus=" + getEstatus() +
            "}";
    }
}
