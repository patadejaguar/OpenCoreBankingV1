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
 * A SistemaErrorTipos.
 */
@Entity
@Table(name = "sistema_error_tipos")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "sistemaerrortipos")
public class SistemaErrorTipos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 80)
    @Column(name = "error_tipos_nom", length = 80)
    private String errorTiposNom;

    @Size(max = 30)
    @Column(name = "error_tipos_alias", length = 30)
    private String errorTiposAlias;

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

    public String getErrorTiposNom() {
        return errorTiposNom;
    }

    public SistemaErrorTipos errorTiposNom(String errorTiposNom) {
        this.errorTiposNom = errorTiposNom;
        return this;
    }

    public void setErrorTiposNom(String errorTiposNom) {
        this.errorTiposNom = errorTiposNom;
    }

    public String getErrorTiposAlias() {
        return errorTiposAlias;
    }

    public SistemaErrorTipos errorTiposAlias(String errorTiposAlias) {
        this.errorTiposAlias = errorTiposAlias;
        return this;
    }

    public void setErrorTiposAlias(String errorTiposAlias) {
        this.errorTiposAlias = errorTiposAlias;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public SistemaErrorTipos estatus(Integer estatus) {
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
        SistemaErrorTipos sistemaErrorTipos = (SistemaErrorTipos) o;
        if (sistemaErrorTipos.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaErrorTipos.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaErrorTipos{" +
            "id=" + getId() +
            ", errorTiposNom='" + getErrorTiposNom() + "'" +
            ", errorTiposAlias='" + getErrorTiposAlias() + "'" +
            ", estatus=" + getEstatus() +
            "}";
    }
}
