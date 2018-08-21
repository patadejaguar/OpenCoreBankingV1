package com.sipakal.safeosms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * canales de comunicacion
 * mail sms wsms=wathsapp sms
 */
@ApiModel(description = "canales de comunicacion mail sms wsms=wathsapp sms")
@Entity
@Table(name = "sistema_com_canales")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "sistemacomcanales")
public class SistemaComCanales implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 10)
    @Column(name = "com_canales_nom", length = 10)
    private String comCanalesNom;

    @Size(max = 30)
    @Column(name = "com_canales_alias", length = 30)
    private String comCanalesAlias;

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

    public String getComCanalesNom() {
        return comCanalesNom;
    }

    public SistemaComCanales comCanalesNom(String comCanalesNom) {
        this.comCanalesNom = comCanalesNom;
        return this;
    }

    public void setComCanalesNom(String comCanalesNom) {
        this.comCanalesNom = comCanalesNom;
    }

    public String getComCanalesAlias() {
        return comCanalesAlias;
    }

    public SistemaComCanales comCanalesAlias(String comCanalesAlias) {
        this.comCanalesAlias = comCanalesAlias;
        return this;
    }

    public void setComCanalesAlias(String comCanalesAlias) {
        this.comCanalesAlias = comCanalesAlias;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public SistemaComCanales estatus(Integer estatus) {
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
        SistemaComCanales sistemaComCanales = (SistemaComCanales) o;
        if (sistemaComCanales.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sistemaComCanales.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SistemaComCanales{" +
            "id=" + getId() +
            ", comCanalesNom='" + getComCanalesNom() + "'" +
            ", comCanalesAlias='" + getComCanalesAlias() + "'" +
            ", estatus=" + getEstatus() +
            "}";
    }
}
