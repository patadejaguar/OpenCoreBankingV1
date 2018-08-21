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
 * A SistemaNivelRiesgo.
 */
@Entity
@Table(name = "sistema_nivel_riesgo")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "sistemanivelriesgo")
public class SistemaNivelRiesgo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 80)
    @Column(name = "nivel_riesgo_nom", length = 80)
    private String nivelRiesgoNom;

    @Size(max = 30)
    @Column(name = "nivel_riesgo_alias", length = 30)
    private String nivelRiesgoAlias;

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

    public String getNivelRiesgoNom() {
        return nivelRiesgoNom;
    }

    public SistemaNivelRiesgo nivelRiesgoNom(String nivelRiesgoNom) {
        this.nivelRiesgoNom = nivelRiesgoNom;
        return this;
    }

    public void setNivelRiesgoNom(String nivelRiesgoNom) {
        this.nivelRiesgoNom = nivelRiesgoNom;
    }

    public String getNivelRiesgoAlias() {
        return nivelRiesgoAlias;
    }

    public SistemaNivelRiesgo nivelRiesgoAlias(String nivelRiesgoAlias) {
        this.nivelRiesgoAlias = nivelRiesgoAlias;
        return this;
    }

    public void setNivelRiesgoAlias(String nivelRiesgoAlias) {
        this.nivelRiesgoAlias = nivelRiesgoAlias;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public SistemaNivelRiesgo estatus(Integer estatus) {
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
        SistemaNivelRiesgo sistemaNivelRiesgo = (SistemaNivelRiesgo) o;
        if (sistemaNivelRiesgo.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaNivelRiesgo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaNivelRiesgo{" +
            "id=" + getId() +
            ", nivelRiesgoNom='" + getNivelRiesgoNom() + "'" +
            ", nivelRiesgoAlias='" + getNivelRiesgoAlias() + "'" +
            ", estatus=" + getEstatus() +
            "}";
    }
}
