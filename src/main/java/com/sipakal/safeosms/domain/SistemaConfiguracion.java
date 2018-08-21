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
 * A SistemaConfiguracion.
 */
@Entity
@Table(name = "sistema_configuracion")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "sistemaconfiguracion")
public class SistemaConfiguracion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 80)
    @Column(name = "configuracion_nom", length = 80)
    private String configuracionNom;

    @Size(max = 15)
    @Column(name = "configuracion_tipo", length = 15)
    private String configuracionTipo;

    /**
     * INT,CHAR,REAL
     */
    @Size(max = 100)
    @ApiModelProperty(value = "INT,CHAR,REAL")
    @Column(name = "configuracion_val", length = 100)
    private String configuracionVal;

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

    public String getConfiguracionNom() {
        return configuracionNom;
    }

    public SistemaConfiguracion configuracionNom(String configuracionNom) {
        this.configuracionNom = configuracionNom;
        return this;
    }

    public void setConfiguracionNom(String configuracionNom) {
        this.configuracionNom = configuracionNom;
    }

    public String getConfiguracionTipo() {
        return configuracionTipo;
    }

    public SistemaConfiguracion configuracionTipo(String configuracionTipo) {
        this.configuracionTipo = configuracionTipo;
        return this;
    }

    public void setConfiguracionTipo(String configuracionTipo) {
        this.configuracionTipo = configuracionTipo;
    }

    public String getConfiguracionVal() {
        return configuracionVal;
    }

    public SistemaConfiguracion configuracionVal(String configuracionVal) {
        this.configuracionVal = configuracionVal;
        return this;
    }

    public void setConfiguracionVal(String configuracionVal) {
        this.configuracionVal = configuracionVal;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public SistemaConfiguracion estatus(Integer estatus) {
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
        SistemaConfiguracion sistemaConfiguracion = (SistemaConfiguracion) o;
        if (sistemaConfiguracion.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaConfiguracion.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaConfiguracion{" +
            "id=" + getId() +
            ", configuracionNom='" + getConfiguracionNom() + "'" +
            ", configuracionTipo='" + getConfiguracionTipo() + "'" +
            ", configuracionVal='" + getConfiguracionVal() + "'" +
            ", estatus=" + getEstatus() +
            "}";
    }
}
