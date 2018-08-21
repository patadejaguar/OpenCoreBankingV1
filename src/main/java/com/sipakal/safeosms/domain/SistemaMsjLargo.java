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
 * A SistemaMsjLargo.
 */
@Entity
@Table(name = "sistema_msj_largo")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "sistemamsjlargo")
public class SistemaMsjLargo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 80)
    @Column(name = "msj_largo_nom", length = 80)
    private String msjLargoNom;

    @Size(max = 150)
    @Column(name = "msj_largo_texto", length = 150)
    private String msjLargoTexto;

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

    public String getMsjLargoNom() {
        return msjLargoNom;
    }

    public SistemaMsjLargo msjLargoNom(String msjLargoNom) {
        this.msjLargoNom = msjLargoNom;
        return this;
    }

    public void setMsjLargoNom(String msjLargoNom) {
        this.msjLargoNom = msjLargoNom;
    }

    public String getMsjLargoTexto() {
        return msjLargoTexto;
    }

    public SistemaMsjLargo msjLargoTexto(String msjLargoTexto) {
        this.msjLargoTexto = msjLargoTexto;
        return this;
    }

    public void setMsjLargoTexto(String msjLargoTexto) {
        this.msjLargoTexto = msjLargoTexto;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public SistemaMsjLargo estatus(Integer estatus) {
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
        SistemaMsjLargo sistemaMsjLargo = (SistemaMsjLargo) o;
        if (sistemaMsjLargo.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaMsjLargo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaMsjLargo{" +
            "id=" + getId() +
            ", msjLargoNom='" + getMsjLargoNom() + "'" +
            ", msjLargoTexto='" + getMsjLargoTexto() + "'" +
            ", estatus=" + getEstatus() +
            "}";
    }
}
