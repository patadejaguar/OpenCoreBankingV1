package com.sipakal.safeosms.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * A SistemaCatalogoInterno.
 */
@Entity
@Table(name = "sistema_catalogo_interno")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "sistemacatalogointerno")
public class SistemaCatalogoInterno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 80)
    @Column(name = "catalogo_interno_tbl", length = 80)
    private String catalogoInternoTbl;

    @Size(max = 80)
    @Column(name = "catalogo_interno_nom", length = 80)
    private String catalogoInternoNom;

    @Size(max = 100)
    @Column(name = "catalogo_interno_val", length = 100)
    private String catalogoInternoVal;

    /**
     * Estado Activo/Inactivo 1/0
     */
    @Max(value = 9)
    @ApiModelProperty(value = "Estado Activo/Inactivo 1/0")
    @Column(name = "estatus")
    private Integer estatus;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatalogoInternoTbl() {
        return catalogoInternoTbl;
    }

    public SistemaCatalogoInterno catalogoInternoTbl(String catalogoInternoTbl) {
        this.catalogoInternoTbl = catalogoInternoTbl;
        return this;
    }

    public void setCatalogoInternoTbl(String catalogoInternoTbl) {
        this.catalogoInternoTbl = catalogoInternoTbl;
    }

    public String getCatalogoInternoNom() {
        return catalogoInternoNom;
    }

    public SistemaCatalogoInterno catalogoInternoNom(String catalogoInternoNom) {
        this.catalogoInternoNom = catalogoInternoNom;
        return this;
    }

    public void setCatalogoInternoNom(String catalogoInternoNom) {
        this.catalogoInternoNom = catalogoInternoNom;
    }

    public String getCatalogoInternoVal() {
        return catalogoInternoVal;
    }

    public SistemaCatalogoInterno catalogoInternoVal(String catalogoInternoVal) {
        this.catalogoInternoVal = catalogoInternoVal;
        return this;
    }

    public void setCatalogoInternoVal(String catalogoInternoVal) {
        this.catalogoInternoVal = catalogoInternoVal;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public SistemaCatalogoInterno estatus(Integer estatus) {
        this.estatus = estatus;
        return this;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SistemaCatalogoInterno sistemaCatalogoInterno = (SistemaCatalogoInterno) o;
        if (sistemaCatalogoInterno.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaCatalogoInterno.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaCatalogoInterno{" +
            "id=" + getId() +
            ", catalogoInternoTbl='" + getCatalogoInternoTbl() + "'" +
            ", catalogoInternoNom='" + getCatalogoInternoNom() + "'" +
            ", catalogoInternoVal='" + getCatalogoInternoVal() + "'" +
            ", estatus=" + getEstatus() +
            "}";
    }
}
